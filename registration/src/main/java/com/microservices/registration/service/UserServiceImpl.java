package com.microservices.registration.service;

import com.microservices.registration.dto.UserDto;
import com.microservices.registration.entity.Customer;
import com.microservices.registration.entity.User;
import com.microservices.registration.repository.CustomerRepository;
import com.microservices.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(UserDto userDto) {
        User newUser=new User();
        Optional<Customer> existingCustomer=customerRepository.findById(userDto.getId());
        if(userRepository.existsById(userDto.getId())){
            throw new RuntimeException("User already exists");
        }else if(existingCustomer.get().getId()== userDto.getId()&&userDto.getOtp()==465445){
            newUser.setId(userDto.getId());
            newUser.setFirstname(existingCustomer.get().getFirstname());
            newUser.setLastname(existingCustomer.get().getLastname());
            newUser.setEmail(existingCustomer.get().getEmail());
            newUser.setMobileNumber(existingCustomer.get().getMobileNumber());
            newUser.setUsername(userDto.getUsername());
            newUser.setPassword(userDto.getPassword());
            userRepository.save(newUser);
            return newUser;
        }else System.out.println("OTP is incorrect");
        return null;
    }
}
