package com.microservices.registration.service;

import com.microservices.registration.dto.UserDto;
import com.microservices.registration.entity.User;

public interface UserService {
    User saveUser(UserDto userDto);
}
