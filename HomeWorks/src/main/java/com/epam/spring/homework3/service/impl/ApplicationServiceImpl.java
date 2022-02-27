package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;
import com.epam.spring.homework3.persistence.entity.Application;
import com.epam.spring.homework3.persistence.mapper.ApplicationMapper;
import com.epam.spring.homework3.persistence.repository.ApplicationRepository;
import com.epam.spring.homework3.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public ApplicationDTO getApplication(int id) {
        log.info(this.getClass().getSimpleName() + "get application method");
        Application application = applicationRepository.getApplication(id);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }

    @Override
    public List<ApplicationDTO> getApplicationsByMaster(int id) {
        log.info(this.getClass().getSimpleName() + ". getApplicationsByMaster method");
        return ApplicationMapper.INSTANCE
                .mapApplicationsToApplicationsDTO(applicationRepository.listApplications().stream()
                    .filter(application -> application.getMaster().getId() == id)
                    .collect(Collectors.toList()));
    }

    @Override
    public List<ApplicationDTO> getAppointmentsByClient(int id) {
        log.info(this.getClass().getSimpleName() + ". getApplicationsByClient method");
        return ApplicationMapper.INSTANCE
                .mapApplicationsToApplicationsDTO(applicationRepository.listApplications().stream()
                        .filter(application -> application.getClient().getId() == id)
                        .collect(Collectors.toList()));
    }

    @Override
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        log.info(this.getClass().getSimpleName() + " createApplication method");
        Application application = ApplicationMapper.INSTANCE.mapApplicationDTOToApplication(applicationDTO);
        application = applicationRepository.createApplication(application);
        return ApplicationMapper.INSTANCE.mapApplicationToApplicationDTO(application);
    }
}
