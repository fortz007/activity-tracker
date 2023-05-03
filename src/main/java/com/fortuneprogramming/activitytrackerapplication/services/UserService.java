package com.fortuneprogramming.activitytrackerapplication.services;

import com.fortuneprogramming.activitytrackerapplication.dtos.userdto.UserResponseDto;
import com.fortuneprogramming.activitytrackerapplication.dtos.userdto.UserSignupDto;
import com.fortuneprogramming.activitytrackerapplication.entities.User;
import com.fortuneprogramming.activitytrackerapplication.exceptions.AlreadyExistsException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotFoundException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotNullException;
import com.fortuneprogramming.activitytrackerapplication.utils.ApiResponse;

public interface UserService {
    boolean isUserExist(String email);

    boolean isUserExistByEmailAndPassword(String email, String Password);

    ApiResponse<User> signup(UserSignupDto userSignupDto) throws AlreadyExistsException, NotNullException;
    ApiResponse<UserResponseDto> login(String email, String password) throws NotNullException, NotFoundException;
}
