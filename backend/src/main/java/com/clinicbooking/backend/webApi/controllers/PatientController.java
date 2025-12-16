package com.clinicbooking.backend.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clinicbooking.backend.business.abstracts.PatientService;
import com.clinicbooking.backend.business.requests.CreatePatientRequest;
import com.clinicbooking.backend.business.responses.PatientResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> register(@Valid @RequestBody CreatePatientRequest request) {
        PatientResponse response = patientService.register(request);
        return ResponseEntity.ok(response);
    }
}
