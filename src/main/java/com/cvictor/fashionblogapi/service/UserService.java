package com.cvictor.fashionblogapi.service;

import com.cvictor.fashionblogapi.dto.request.LoginRequest;
import com.cvictor.fashionblogapi.dto.request.UserRequestDto;
import com.cvictor.fashionblogapi.dto.response.UserResponseDto;

public interface UserService {


    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto logInUser(LoginRequest loginRequest);




}
