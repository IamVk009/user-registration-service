package com.registration.user.service;

import com.registration.user.dto.UserDto;

public interface UserService {

    UserDto registerUser(UserDto userDto);

    String loginUser(String userName, String userPassword);
}
