package com.clinicbooking.backend.business.rules;

import org.springframework.stereotype.Service;

import com.clinicbooking.backend.core.exceptions.BusinessException;
import com.clinicbooking.backend.dataAccess.abstracts.DepartmentRepository;

@Service
public class DepartmentBusinessRules {

    private final DepartmentRepository departmentRepository;

    public DepartmentBusinessRules(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void checkIfNameExists(String name) {
        if (departmentRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException("Department name already exists");
        }
    }
}
