package com.clinicbooking.backend.business.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDoctorByIdResponse {

    private int id;
    private String firstName;
    private String lastName;
    private int departmentId;
    private String departmentName;
    private String email;
    private String phone;
}
