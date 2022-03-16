package com.epam.spring.homework3.service;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;

import java.util.List;
import java.util.Set;

public interface ApplicationService {

    ApplicationDTO getApplication(int id);

    Set<ApplicationDTO> getApplicationsByMaster(int id);

    Set<ApplicationDTO> getAppointmentsByClient(int id);

    ApplicationDTO createApplication(int clientId, ApplicationDTO applicationDTO);

    ApplicationDTO updateApplication(int id, ApplicationDTO applicationDTO);

    ApplicationDTO assignMaster(int applicationId, int masterId);

    List<ApplicationDTO> getAllApplication();
}
