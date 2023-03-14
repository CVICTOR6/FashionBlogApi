package com.cvictor.fashionblogapi.controller;

import com.cvictor.fashionblogapi.dto.request.LoginRequest;
import com.cvictor.fashionblogapi.dto.request.UserRequestDto;
import com.cvictor.fashionblogapi.dto.response.ApiResponse;
import com.cvictor.fashionblogapi.dto.response.UserResponseDto;
import com.cvictor.fashionblogapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //Routing and Validating
    //CRUD

    //Exceptions Handling
    //Validation
    //Uniform Interface --> ApiResponse

    @PostMapping(path = "/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto request) {
        log.info("create user call for name: {}", request.getName());
        UserResponseDto response =  userService.createUser(request);

        //Using constructor
//        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
//        apiResponse.setData(response);
//        apiResponse.setStatusCode("200");
//        apiResponse.setMessage("created user successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest login) {
        UserResponseDto foundUser = userService.logInUser(login);

//        return ResponseEntity.ok(foundUser);
//        return new ResponseEntity<>(foundUser, HttpStatus.OK);

        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(foundUser);
        apiResponse.setStatusCode("00");
        apiResponse.setMessage("user fetch");

        return ResponseEntity.status(200).body(apiResponse);
    }

//    @DeleteMapping(path = "{userId}/user")
//    public ResponseEntity<Object> deleteUserById(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//
//        ApiResponse<String> apiResponse = new ApiResponse<>();
//        apiResponse.setData("User Deleted");
//        apiResponse.setStatusCode("00");
//
//        return ResponseEntity.status(202).body(apiResponse);
//    }

//    @PutMapping(path = "{userId}/user")
//    public ResponseEntity<Object> updateUserById(@PathVariable Long userId, @RequestBody UserRequestDto request) {
//        UserResponseDto response = userService.updateUser(userId, request);
//
//        ApiResponse<UserResponseDto> apiResponse = new ApiResponse<>();
//        apiResponse.setData(response);
//        apiResponse.setStatusCode("00");
//        apiResponse.setMessage("updated successfully");
//
//        return ResponseEntity.status(202).body(apiResponse);
//    }
}
