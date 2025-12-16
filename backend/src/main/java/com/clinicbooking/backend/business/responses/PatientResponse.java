package com.clinicbooking.backend.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
