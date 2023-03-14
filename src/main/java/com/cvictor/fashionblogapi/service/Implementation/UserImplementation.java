package com.cvictor.fashionblogapi.service.Implementation;

import com.cvictor.fashionblogapi.dto.request.LoginRequest;
import com.cvictor.fashionblogapi.dto.request.UserRequestDto;
import com.cvictor.fashionblogapi.dto.response.UserResponseDto;
import com.cvictor.fashionblogapi.entity.User;
import com.cvictor.fashionblogapi.repository.UserRepository;
import com.cvictor.fashionblogapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserImplementation implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        log.info("service:: about setting");
        User user = userRepository.findByEmail(userRequestDto.getEmail()).orElse(null);
        if (user == null) {

          User savedUser = userRepository.save( User.builder()
                   .name(userRequestDto.getName())
                   .email(userRequestDto.getEmail())
                   .password(userRequestDto.getPassword())
                    .gender(userRequestDto.getGender())
                   .role(userRequestDto.getRole())
                   .build());

            return UserResponseDto.builder()
                    .name(savedUser.getName())
                    .userId(savedUser.getUserid())
                    .role(savedUser.getRole())
                    .build();

        }

        else {return null;}

    }

    @Override
    public UserResponseDto logInUser(LoginRequest loginRequest) {
         User user =  userRepository.getUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).orElse( null);

         if (user == null) {return null;}

        return UserResponseDto.builder()
                .name(user.getName())
                .userId(user.getUserid())
                .role(user.getRole())
                .build();
    }



}
