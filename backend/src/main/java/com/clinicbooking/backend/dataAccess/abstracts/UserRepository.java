package com.clinicbooking.backend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicbooking.backend.entities.concretes.User;

public interface UserRepository  extends JpaRepository<User, Integer> 
{
    boolean existsByPhone(String phone);

    boolean existsByEmailIgnoreCase(String email);

    Optional<User> findByPhone(String phone);

    Optional<User> findByEmailIgnoreCase(String email);
}
