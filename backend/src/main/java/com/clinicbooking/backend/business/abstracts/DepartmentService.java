package com.clinicbooking.backend.business.abstracts;

import java.util.List;

import com.clinicbooking.backend.business.requests.CreateDepartmentRequest;
import com.clinicbooking.backend.business.requests.UpdateDepartmentRequest;
import com.clinicbooking.backend.business.responses.DepartmentResponse;

public interface DepartmentService {
    List<DepartmentResponse> getAll();
    DepartmentResponse getById(int id);
    void add(CreateDepartmentRequest request);
    void update(UpdateDepartmentRequest request);
    void delete(int id);
}
