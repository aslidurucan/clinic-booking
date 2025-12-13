package com.clinicbooking.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entities.concretes.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
