package com.clinicbooking.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entities.concretes.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
