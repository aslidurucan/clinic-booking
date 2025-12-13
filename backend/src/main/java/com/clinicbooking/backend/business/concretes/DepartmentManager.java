package com.clinicbooking.backend.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clinicbooking.backend.business.abstracts.DepartmentService;
import com.clinicbooking.backend.business.requests.CreateDepartmentRequest;
import com.clinicbooking.backend.business.requests.UpdateDepartmentRequest;
import com.clinicbooking.backend.business.responses.DepartmentResponse;
import com.clinicbooking.backend.business.rules.DepartmentBusinessRules;
import com.clinicbooking.backend.core.exceptions.BusinessException;
import com.clinicbooking.backend.core.utilities.mappers.ModelMapperService;
import com.clinicbooking.backend.dataAccess.abstracts.DepartmentRepository;
import com.clinicbooking.backend.dataAccess.abstracts.DoctorRepository;
import com.clinicbooking.backend.entities.concretes.Department;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManager implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapperService modelMapperService;
    private DepartmentBusinessRules departmentBusinessRules;
    private DoctorRepository doctorRepository;

    @Override
    public List<DepartmentResponse> getAll() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(dep -> modelMapperService.forResponse().map(dep, DepartmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse getById(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found: " + id));

        return modelMapperService.forResponse().map(department, DepartmentResponse.class);
    }

    @Override
public void add(CreateDepartmentRequest request) {
    departmentBusinessRules.checkIfNameExists(request.getName());

    Department department = modelMapperService.forRequest().map(request, Department.class);
    departmentRepository.save(department);
}


    @Override
    public void update(UpdateDepartmentRequest request) {
        Department existing = departmentRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Department not found: " + request.getId()));

        if (!existing.getName().equalsIgnoreCase(request.getName())
                && departmentRepository.existsByNameIgnoreCase(request.getName())) {
            throw new RuntimeException("Department name already exists: " + request.getName());
        }

        modelMapperService.forRequest().map(request, existing);
        departmentRepository.save(existing);
    }

    public void delete(int id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found: " + id);
        }

        if (doctorRepository.existsByDepartment_Id(id)) {
            throw new BusinessException("Cannot delete department because doctors exist in this department");
        }

        departmentRepository.deleteById(id);
    }
}
