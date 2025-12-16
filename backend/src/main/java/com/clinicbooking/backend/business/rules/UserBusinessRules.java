package com.clinicbooking.backend.business.rules;

import org.springframework.stereotype.Service;

import com.clinicbooking.backend.core.exceptions.BusinessException;
import com.clinicbooking.backend.dataAccess.abstracts.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void checkIfPhoneExists(String phone) {
        if (userRepository.existsByPhone(phone)) {
            throw new BusinessException("Phone already exists");
        }
    }

    public void checkIfEmailExists(String email) {
        if (userRepository.existsByEmailIgnoreCase(email)) {
            throw new BusinessException("Email already exists");
        }
    }
}
