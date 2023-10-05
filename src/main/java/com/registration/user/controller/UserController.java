package com.registration.user.controller;

import com.registration.user.dto.UserDto;
import com.registration.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<UserDto> registerUserController(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLoginController(@RequestParam String userName, @RequestParam String userPassword){
        logger.info("UserName = " + userName);
        logger.info("UserPassword = " + userPassword);
        return new ResponseEntity<>(userService.loginUser(userName, userPassword), HttpStatus.OK);
    }
}
