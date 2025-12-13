package com.clinicbooking.backend.business.abstracts;

import com.clinicbooking.backend.business.requests.CreateDoctorRequest;
import com.clinicbooking.backend.business.requests.UpdateDoctorRequest;
import com.clinicbooking.backend.business.responses.GetAllDoctorsResponse;
import com.clinicbooking.backend.business.responses.GetDoctorByIdResponse;

import java.util.List;

public interface DoctorService {

    List<GetAllDoctorsResponse> getAll();

    GetDoctorByIdResponse getById(int id);

    void add(CreateDoctorRequest request);

    void update(UpdateDoctorRequest request);

    void delete(int id);
}
