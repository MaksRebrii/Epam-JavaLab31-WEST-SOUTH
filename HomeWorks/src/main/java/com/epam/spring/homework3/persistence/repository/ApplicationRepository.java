package com.epam.spring.homework3.persistence.repository;

import com.epam.spring.homework3.persistence.entity.Application;

import java.util.List;

public interface ApplicationRepository {

    Application getApplication(int id);

    List<Application> listApplications();

    Application createApplication(Application application);

    Application updateApplication(int id, Application application);

    void deleteApplication(int id);
}
