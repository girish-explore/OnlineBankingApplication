package com.microservices.registration.service;

import com.microservices.registration.dto.UserDto;
import com.microservices.registration.entity.User;
import com.microservices.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        User existingUser=userRepository.findByUsernameAndPassword(username, password);
        if (existingUser!=null){
            return "Login Successfully";
        }else return "Login UnSuccessfully";
    }
}
