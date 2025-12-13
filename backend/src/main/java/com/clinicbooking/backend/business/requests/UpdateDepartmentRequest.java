package com.clinicbooking.backend.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDepartmentRequest {

    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    private String description;
}
