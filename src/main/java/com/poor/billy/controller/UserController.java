package com.poor.billy.controller;

import com.poor.billy.dto.UserRegistrationDTO;
import com.poor.billy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    // DI
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Long> registration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return new ResponseEntity<>(userService.registration(userRegistrationDTO), HttpStatus.OK);
    }
}