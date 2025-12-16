package com.clinicbooking.backend.business.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters.")
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Size(max = 50, message = "Email must be at most 50 characters.")
    @Email(message = "Email format is invalid.")
    private String email;

     @NotBlank(message = "Phone is required.")
     @Size(min = 10, max = 15, message = "Phone must be between 10 and 15 digits.")
     @Pattern(
        regexp = "^(\\+?[0-9]{10,15})$",
        message = "Phone must contain 10 to 15 digits (optionally starting with +)."
    )
    private String phone;
    
    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters.")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#^()_+\\-={}\\[\\]:;\"'<>,.\\/\\\\|`~]).{8,64}$",
        message = "Password must be 8-64 chars and include upper, lower, number, and special character."
    )
    private String password;
}
