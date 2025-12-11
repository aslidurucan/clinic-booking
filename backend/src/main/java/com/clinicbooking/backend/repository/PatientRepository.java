package com.clinicbooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
