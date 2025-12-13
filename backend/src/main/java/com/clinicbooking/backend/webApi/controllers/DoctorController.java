package com.clinicbooking.backend.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.clinicbooking.backend.business.abstracts.DoctorService;
import com.clinicbooking.backend.business.requests.CreateDoctorRequest;
import com.clinicbooking.backend.business.requests.UpdateDoctorRequest;
import com.clinicbooking.backend.business.responses.GetAllDoctorsResponse;
import com.clinicbooking.backend.business.responses.GetDoctorByIdResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;

    @GetMapping
    public List<GetAllDoctorsResponse> getAll() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public GetDoctorByIdResponse getById(@PathVariable int id) {
        return doctorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateDoctorRequest request) {
        doctorService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateDoctorRequest request) {
        doctorService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        doctorService.delete(id);
    }
}
