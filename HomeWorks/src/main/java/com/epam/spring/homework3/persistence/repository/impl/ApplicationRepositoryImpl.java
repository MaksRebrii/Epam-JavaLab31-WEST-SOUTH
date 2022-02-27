package com.epam.spring.homework3.persistence.repository.impl;

import com.epam.spring.homework3.persistence.entity.Application;
import com.epam.spring.homework3.persistence.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final List<Application> applicationList = new ArrayList<>();

    @Override
    public Application getApplication(int id) {
        log.info(this.getClass().getSimpleName() + "get application with id {}", id);
        return applicationList.stream()
                .filter(application -> application.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User in not found"));
    }

    @Override
    public List<Application> listApplications() {
        log.info(this.getClass().getSimpleName() + "get all applications");
        return new ArrayList<>(applicationList);
    }

    @Override
    public Application createApplication(Application application) {
        log.info(this.getClass().getSimpleName() + "create new application {}", application);
        applicationList.add(application);
        return application;
    }

    @Override
    public Application updateApplication(int id, Application application) {
        log.info(this.getClass().getSimpleName() + "update application with id {}", id);
        boolean isDeleted = applicationList.removeIf(a -> a.getId() == id);
        if (isDeleted) {
            applicationList.add(application);
        } else {
            throw new RuntimeException("Patient is not found!");
        }
        return application;
    }

    @Override
    public void deleteApplication(int id) {
        log.info(this.getClass().getSimpleName() + "delete application by id{}", id);
        applicationList.removeIf(application -> application.getId() == id);
    }
}
