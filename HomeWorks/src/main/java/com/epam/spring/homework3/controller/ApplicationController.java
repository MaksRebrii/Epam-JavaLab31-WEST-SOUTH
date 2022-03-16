package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.persistence.dto.ApplicationDTO;
import com.epam.spring.homework3.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api("API for retrieving application data")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class ApplicationController {

    private final ApplicationService applicationService;

    @ApiOperation("Get application by master id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/master/{masterId}/application")
    public Set<ApplicationDTO> getApplicationsByMasterId(@PathVariable("masterId") int id){
        log.info(this.getClass().getSimpleName() + " getApplicationsByMaster endpoint");
        return applicationService.getApplicationsByMaster(id);
    }

    @ApiOperation("Get application by client id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client/{clientId}/application")
    public Set<ApplicationDTO> getApplicationsByClientId(@PathVariable("clientId") int id){
        log.info(this.getClass().getSimpleName() + " getApplicationsByClient endpoint");
        return applicationService.getAppointmentsByClient(id);
    }

    @ApiOperation("Get application by  id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/application/{id}")
    public ApplicationDTO getApplication(@PathVariable int id){
        log.info(this.getClass().getSimpleName() + " getApplication endpoint");
        return applicationService.getApplication(id);
    }

    @ApiOperation("Get application by  id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/application")
    public List<ApplicationDTO> getAllApplication(){
        log.info(this.getClass().getSimpleName() + " getAllApplication endpoint");
        return applicationService.getAllApplication();
    }

    @ApiOperation("Create an application")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/client/{clientId}/application")
    public ApplicationDTO createApplication(@PathVariable int clientId, @RequestBody ApplicationDTO applicationDTO){
        log.info(this.getClass().getSimpleName() + " createApplication endpoint");
        return applicationService.createApplication(clientId, applicationDTO);
    }

    @ApiOperation("Update an application by id")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/application/{id}")
    public ApplicationDTO updateApplication(@PathVariable int id, @RequestBody ApplicationDTO applicationDTO){
        log.info(this.getClass().getSimpleName() + " updateApplication endpoint");
        return applicationService.updateApplication(id, applicationDTO);
    }

    @ApiOperation("Assign a master to  the application")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/application/{applicationId}/master/{masterId}")
    public ApplicationDTO assignMaster(@PathVariable int applicationId, @PathVariable int masterId){
        log.info(this.getClass().getSimpleName() + " assign master to the application endpoint");
        return applicationService.assignMaster(applicationId, masterId);
    }
}
