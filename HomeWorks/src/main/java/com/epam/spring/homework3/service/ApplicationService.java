package com.epam.spring.homework3.service;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

    ApplicationDTO getApplication(int id);

    List<ApplicationDTO> getApplicationsByMaster(int id);

    List<ApplicationDTO> getAppointmentsByClient(int id);

    ApplicationDTO createApplication(ApplicationDTO applicationDTO);
}
