package com.epam.spring.homework3.persistence.repository;

import com.epam.spring.homework3.persistence.entity.Application;

import java.util.List;
import java.util.Set;

public interface ApplicationRepository {

    Application getApplication(int id);

    List<Application> listApplications();

    Application createApplication(Application application);

    Application updateApplication(int id, Application application);

    Set<Application> getApplicationsByMaster(int id);

    Set<Application> getApplicationsByClient(int id);
}
