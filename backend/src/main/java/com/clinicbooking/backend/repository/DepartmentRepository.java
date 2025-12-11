package com.clinicbooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
