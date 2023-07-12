package com.microservices.registration.service;

import com.microservices.registration.dto.LoginDto;

public interface LoginService {
    String login(String username, String password);
}
