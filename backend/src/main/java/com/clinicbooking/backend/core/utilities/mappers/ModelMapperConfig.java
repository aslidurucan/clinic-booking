package com.clinicbooking.backend.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();

    mapper.typeMap(
            com.clinicbooking.backend.business.requests.CreateDoctorRequest.class,
            com.clinicbooking.backend.entities.concretes.Doctor.class
    ).addMappings(mapping  -> mapping.skip(com.clinicbooking.backend.entities.concretes.Doctor::setId));

    mapper.typeMap(
            com.clinicbooking.backend.business.requests.UpdateDoctorRequest.class,
            com.clinicbooking.backend.entities.concretes.Doctor.class
    ).addMappings(mapping  -> mapping.skip(com.clinicbooking.backend.entities.concretes.Doctor::setId));

    return mapper;
}

}
