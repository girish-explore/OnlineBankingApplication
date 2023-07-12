package com.microservices.registration.controller;

import com.microservices.registration.dto.UserDto;
import com.microservices.registration.entity.User;
import com.microservices.registration.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    public RegistrationController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        User newUser=userService.saveUser(userDto);
        if(newUser!=null) {
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
