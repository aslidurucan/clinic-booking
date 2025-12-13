package com.clinicbooking.backend.business.rules;

import com.clinicbooking.backend.core.exceptions.BusinessException;
import com.clinicbooking.backend.dataAccess.abstracts.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorBusinessRules {

    private final DoctorRepository doctorRepository;

    public DoctorBusinessRules(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void checkIfEmailExists(String email) {
        if (doctorRepository.existsByEmail(email)) {
            throw new BusinessException("Email already exists");
        }
    }
}
