package com.registration.user.service.impl;

import com.registration.user.dto.UserDto;
import com.registration.user.entity.User;
import com.registration.user.repository.UserRepository;
import com.registration.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDto registerUser(UserDto userDto) {
        User registeredUser = userRepository.save(dtoToUser(userDto));
        return userToDto(registeredUser);
    }

    @Override
    public String loginUser(String userName, String userPassword) {
        logger.info("Inside Login User");
        User loginUser = userRepository.findByUserNameAndUserPassword(userName, userPassword).orElseThrow(() -> new RuntimeException("Enter Valid Username and Password"));
        logger.info("LoginUser = " + loginUser);
        if(loginUser != null){
            return "User Logged In Successfully...";
        } else {
            return "Enter Valid Username and Password";
        }
    }

    private User dtoToUser(UserDto userDto){
        return User.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .userPassword(userDto.getUserPassword())
                .userAddress(userDto.getUserAddress())
                .userState(userDto.getUserState())
                .userCountry(userDto.getUserCountry())
                .userEmail(userDto.getUserEmail())
                .userPan(userDto.getUserPan())
                .userContact(userDto.getUserContact())
                .userDob(userDto.getUserDob())
                .userAccType(userDto.getUserAccType())
                .build();
    }

    private UserDto userToDto(User user){
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .userAddress(user.getUserAddress())
                .userState(user.getUserState())
                .userCountry(user.getUserCountry())
                .userEmail(user.getUserEmail())
                .userPan(user.getUserPan())
                .userContact(user.getUserContact())
                .userDob(user.getUserDob())
                .userAccType(user.getUserAccType())
                .build();
    }

}
