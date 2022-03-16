package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;
import com.epam.spring.homework3.persistence.entity.Application;
import com.epam.spring.homework3.persistence.entity.User;
import com.epam.spring.homework3.persistence.mapper.ApplicationMapper;
import com.epam.spring.homework3.persistence.repository.ApplicationRepository;
import com.epam.spring.homework3.persistence.repository.UserRepository;
import com.epam.spring.homework3.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    @Override
    public ApplicationDTO getApplication(int id) {
        log.info(this.getClass().getSimpleName() + "get application method");
        Application application = applicationRepository.getApplication(id);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }

    @Override
    public List<ApplicationDTO> getAllApplication() {
        log.info(this.getClass().getSimpleName() + "get allApplication method");
        return ApplicationMapper.INSTANCE
                .mapApplicationsToApplicationsDTO(applicationRepository.listApplications());
    }

    @Override
    public Set<ApplicationDTO> getApplicationsByMaster(int id) {
        log.info(this.getClass().getSimpleName() + ". getApplicationsByMaster method");
        return ApplicationMapper.INSTANCE
                .mapApplicationsToApplicationsDTO(applicationRepository.getApplicationsByMaster(id));
    }

    @Override
    public Set<ApplicationDTO> getAppointmentsByClient(int id) {
        log.info(this.getClass().getSimpleName() + ". getApplicationsByClient method");
        return ApplicationMapper.INSTANCE
                .mapApplicationsToApplicationsDTO(applicationRepository.getApplicationsByClient(id));
    }

    @Override
    public ApplicationDTO createApplication(int clientId, ApplicationDTO applicationDTO) {
        log.info(this.getClass().getSimpleName() + " createApplication method");
        User client = userRepository.getUserById(clientId);
        Application application = ApplicationMapper.INSTANCE.mapApplicationDTOToApplication(applicationDTO);
        application.setClient(client);
        application = applicationRepository.createApplication(application);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }

    @Override
    public ApplicationDTO updateApplication(int id, ApplicationDTO applicationDTO) {
        log.info(this.getClass().getSimpleName() + " updateApplication method");
        Application application = ApplicationMapper.INSTANCE.mapApplicationDTOToApplication(applicationDTO);
        application = applicationRepository.updateApplication(id, application);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }

    @Override
    public ApplicationDTO assignMaster(int applicationId, int masterId) {
        log.info(this.getClass().getSimpleName() + " assignMaster method");
        Application application = applicationRepository.getApplication(applicationId);
        if (application == null) {
            throw new RuntimeException(format("Application with id %d not found", applicationId));
        }

        User master = userRepository.getUserById(masterId);
        application.setMaster(master);
        application = applicationRepository.updateApplication(applicationId, application);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }
}
