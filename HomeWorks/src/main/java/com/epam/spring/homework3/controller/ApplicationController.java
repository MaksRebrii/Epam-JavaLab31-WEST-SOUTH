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


@Slf4j
@RestController
@RequestMapping("/api/v1/application")
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
    @GetMapping("/master")
    public List<ApplicationDTO> getApplicationsByMasterId(@RequestParam("master_id") int id){
        log.info(this.getClass().getSimpleName() + " getApplicationsByMaster endpoint");
        return applicationService.getApplicationsByMaster(id);
    }

    @ApiOperation("Get application by client id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client")
    public List<ApplicationDTO> getApplicationsByClientId(@RequestParam("client_id") int id){
        log.info(this.getClass().getSimpleName() + " getApplicationsByClient endpoint");
        return applicationService.getAppointmentsByClient(id);
    }

    @ApiOperation("Get application by  id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ApplicationDTO getApplication(@PathVariable int id){
        log.info(this.getClass().getSimpleName() + " getApplication method");
        return applicationService.getApplication(id);
    }

    @ApiOperation("Create an application")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApplicationDTO createApplication(@RequestBody ApplicationDTO applicationDTO){
        log.info(this.getClass().getSimpleName() + " createApplication endpoint");
        return applicationService.createApplication(applicationDTO);
    }
}
