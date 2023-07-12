package com.microservices.registration.controller;

import com.microservices.registration.dto.LoginDto;
import com.microservices.registration.dto.UserDto;
import com.microservices.registration.entity.User;
import com.microservices.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> saveUser(@RequestBody LoginDto loginDto){
        String response= loginService.login(loginDto.getUsername(), loginDto.getPassword());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
