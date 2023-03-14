package com.cvictor.fashionblogapi.controller;

import com.cvictor.fashionblogapi.dto.request.PostRequestDto;
import com.cvictor.fashionblogapi.dto.response.ApiResponse;
import com.cvictor.fashionblogapi.dto.response.PostResponseDto;
import com.cvictor.fashionblogapi.dto.response.UserResponseDto;
import com.cvictor.fashionblogapi.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping(path = "/posts")
    public ResponseEntity<PostResponseDto> addPost (@RequestBody @Valid PostRequestDto postRequestDto) {
//        log.info("create user call for name: {}", postRequestDto.getBody());
        PostResponseDto responseDto =  postService.addPost(postRequestDto);


//    public ResponseEntity<PostResponseDto> addPost(@RequestBody @Valid PostRequestDto postRequestDto){
//
        PostResponseDto postResponseDto =  postService.addPost(postRequestDto);

        ApiResponse<UserResponseDto> ApiResponse = new ApiResponse<>();
        ApiResponse.setData(PostRequestDto);
        ApiResponse.setStatusCode("00");
        ApiResponse.setMessage("created post successfully");

//        return new ResponseEntity<PostResponseDto>(ApiResponse, HttpStatus.CREATED);
//    }

}
