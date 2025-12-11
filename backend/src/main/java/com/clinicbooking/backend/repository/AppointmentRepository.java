package com.clinicbooking.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
