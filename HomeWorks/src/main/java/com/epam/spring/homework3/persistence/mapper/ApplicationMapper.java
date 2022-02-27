package com.epam.spring.homework3.persistence.mapper;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;
import com.epam.spring.homework3.persistence.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO mapApplicationToApplicationDTO(Application appointment);

    Application mapApplicationDTOToApplication(ApplicationDTO appointmentDto);

    List<ApplicationDTO> mapApplicationsToApplicationsDTO(List<Application> appointments);
}
