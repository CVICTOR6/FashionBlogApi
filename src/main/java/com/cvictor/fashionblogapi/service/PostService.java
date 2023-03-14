package com.cvictor.fashionblogapi.service;

import com.cvictor.fashionblogapi.dto.request.PostRequestDto;
import com.cvictor.fashionblogapi.dto.request.UserRequestDto;
import com.cvictor.fashionblogapi.dto.response.PostResponseDto;
import com.cvictor.fashionblogapi.entity.Like;
import com.cvictor.fashionblogapi.entity.Post;
import com.cvictor.fashionblogapi.entity.User;

import java.util.List;

public interface PostService {

    PostResponseDto addPost(UserRequestDto userRequestDto, PostRequestDto postRequestDto);

    List<PostResponseDto> getAllPost();

//    PostResponseDto updatePost(Post postId);

    void deletePost(Long postId);

    PostResponseDto getPostById(Long postId);
}
