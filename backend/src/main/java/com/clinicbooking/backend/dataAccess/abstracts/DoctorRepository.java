package com.clinicbooking.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clinicbooking.backend.entities.concretes.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    boolean existsByEmail(String email);
    boolean existsByDepartment_Id(int departmentId);
}
