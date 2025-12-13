package com.clinicbooking.backend.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.clinicbooking.backend.business.abstracts.DepartmentService;
import com.clinicbooking.backend.business.requests.CreateDepartmentRequest;
import com.clinicbooking.backend.business.requests.UpdateDepartmentRequest;
import com.clinicbooking.backend.business.responses.DepartmentResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentResponse> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getById(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateDepartmentRequest request) {
        departmentService.add(request);
    }

    @PutMapping
    public void update(@Valid @RequestBody UpdateDepartmentRequest request) {
        departmentService.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        departmentService.delete(id);
    }
}
