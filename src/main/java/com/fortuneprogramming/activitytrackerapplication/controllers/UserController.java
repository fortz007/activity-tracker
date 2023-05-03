package com.fortuneprogramming.activitytrackerapplication.controllers;


import com.fortuneprogramming.activitytrackerapplication.dtos.userdto.UserResponseDto;
import com.fortuneprogramming.activitytrackerapplication.dtos.userdto.UserSignupDto;
import com.fortuneprogramming.activitytrackerapplication.entities.User;
import com.fortuneprogramming.activitytrackerapplication.exceptions.AlreadyExistsException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotFoundException;
import com.fortuneprogramming.activitytrackerapplication.exceptions.NotNullException;
import com.fortuneprogramming.activitytrackerapplication.services.UserService;
import com.fortuneprogramming.activitytrackerapplication.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activity-tracker")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> signup(@RequestBody UserSignupDto userSignupDto) throws AlreadyExistsException, NotNullException {
        ApiResponse<User> user = userService.signup(userSignupDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDto>> login(@RequestBody User user) throws NotFoundException, NotNullException {
        ApiResponse<UserResponseDto> userResponseDtoApiResponse = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(userResponseDtoApiResponse, HttpStatus.ACCEPTED);
    }


}
