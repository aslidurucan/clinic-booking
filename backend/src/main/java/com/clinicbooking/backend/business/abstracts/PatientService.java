package com.clinicbooking.backend.business.abstracts;

import com.clinicbooking.backend.business.requests.CreatePatientRequest;
import com.clinicbooking.backend.business.responses.PatientResponse;

public interface PatientService {
    PatientResponse register(CreatePatientRequest request);
}
