package com.clinicbooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>   {
    

}
