package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.persistence.dto.UserDTO;
import com.epam.spring.homework3.service.UserService;
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
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Api("API for retrieving user data")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class UserController {

    private final UserService userService;

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers(){
        log.info(this.getClass().getSimpleName() + " getAllUsers endpoint");
        return userService.listUsers();
    }

    @ApiOperation("Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public  UserDTO getUser(@PathVariable String email){
        log.info(this.getClass().getSimpleName() + " getUserByEmail endpoint");
        return userService.getUser(email);
    }

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        log.info(this.getClass().getSimpleName() + " createUser endpoint");
        return userService.createUser(userDTO);
    }

    @ApiOperation("Update user by email")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDTO updateUser(@PathVariable String email, @RequestBody UserDTO userDTO){
        log.info(this.getClass().getSimpleName() + " updateUser endpoint");
        return userService.updateUser(email, userDTO);
    }

    @ApiOperation("Delete user by email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email){
        log.info(this.getClass().getSimpleName() + " deleteUser  endpoint");
        userService.deleteUser(email);
    }
}
