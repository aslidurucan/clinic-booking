package com.clinicbooking.backend.business.concretes;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.clinicbooking.backend.business.abstracts.PatientService;
import com.clinicbooking.backend.business.requests.CreatePatientRequest;
import com.clinicbooking.backend.business.responses.PatientResponse;
import com.clinicbooking.backend.business.rules.UserBusinessRules;
import com.clinicbooking.backend.dataAccess.abstracts.PatientRepository;
import com.clinicbooking.backend.dataAccess.abstracts.UserRepository;
import com.clinicbooking.backend.entities.concretes.Patient;
import com.clinicbooking.backend.entities.concretes.Role;
import com.clinicbooking.backend.entities.concretes.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class PatientManager implements PatientService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final UserBusinessRules userBusinessRules;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public PatientResponse register(CreatePatientRequest request) {

    String email = request.getEmail().trim().toLowerCase();
        String phone = request.getPhone().trim().replaceAll("\\s+", "");

        userBusinessRules.checkIfEmailExists(email);
        userBusinessRules.checkIfPhoneExists(phone);

        User user = new User();
        user.setEmail(email);
        user.setPhone(phone);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.PATIENT);

        user = userRepository.save(user);

        Patient patient = modelMapper.map(request, Patient.class);
        patient.setUser(user);

        patient = patientRepository.save(patient);

        PatientResponse response = modelMapper.map(patient, PatientResponse.class);
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());

        return response;
    }
}
