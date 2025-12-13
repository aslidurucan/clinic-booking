package com.clinicbooking.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entities.concretes.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
