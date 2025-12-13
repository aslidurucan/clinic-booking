package com.clinicbooking.backend.business.concretes;

import com.clinicbooking.backend.business.abstracts.DoctorService;
import com.clinicbooking.backend.business.requests.CreateDoctorRequest;
import com.clinicbooking.backend.business.requests.UpdateDoctorRequest;
import com.clinicbooking.backend.business.responses.GetAllDoctorsResponse;
import com.clinicbooking.backend.business.responses.GetDoctorByIdResponse;
import com.clinicbooking.backend.business.rules.DoctorBusinessRules;
import com.clinicbooking.backend.core.utilities.mappers.ModelMapperService;
import com.clinicbooking.backend.dataAccess.abstracts.DepartmentRepository;
import com.clinicbooking.backend.dataAccess.abstracts.DoctorRepository;
import com.clinicbooking.backend.entities.concretes.Department;
import com.clinicbooking.backend.entities.concretes.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorManager implements DoctorService {

    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;
    private ModelMapperService modelMapperService;
    private DoctorBusinessRules doctorBusinessRules;

    @Override
    public List<GetAllDoctorsResponse> getAll() {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors.stream()
                .map(doctor -> {
    GetAllDoctorsResponse doctorResponse =
            modelMapperService.forResponse().map(doctor, GetAllDoctorsResponse.class);

    doctorResponse.setDepartmentId(doctor.getDepartment().getId());
    doctorResponse.setDepartmentName(doctor.getDepartment().getName());

    return doctorResponse;
})

                .collect(Collectors.toList());
    }

    @Override
    public GetDoctorByIdResponse getById(int id) {
        Doctor doctor = doctorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Doctor not found: " + id));

GetDoctorByIdResponse doctorResponse =
        modelMapperService.forResponse().map(doctor, GetDoctorByIdResponse.class);

doctorResponse.setDepartmentId(doctor.getDepartment().getId());
doctorResponse.setDepartmentName(doctor.getDepartment().getName());

return doctorResponse;

    }

    @Override
    public void add(CreateDoctorRequest request) {
        doctorBusinessRules.checkIfEmailExists(request.getEmail());

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found: " + request.getDepartmentId()));

        Doctor doctor = modelMapperService.forRequest().map(request, Doctor.class);
        doctor.setDepartment(department); 

        doctorRepository.save(doctor);
    }

    @Override
public void update(UpdateDoctorRequest request) {

    Doctor existingDoctor = doctorRepository.findById(request.getId())
            .orElseThrow(() -> new RuntimeException("Doctor not found: " + request.getId()));

    Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(() -> new RuntimeException("Department not found: " + request.getDepartmentId()));

    modelMapperService.forRequest().map(request, existingDoctor);
    existingDoctor.setDepartment(department);

    doctorRepository.save(existingDoctor);
}


    @Override
public void delete(int id) {
    if (!doctorRepository.existsById(id)) {
        throw new RuntimeException("Doctor not found: " + id);
    }
    doctorRepository.deleteById(id);
}

}
