package com.cvictor.fashionblogapi.service.Implementation;

import com.cvictor.fashionblogapi.dto.request.PostRequestDto;
import com.cvictor.fashionblogapi.dto.request.UserRequestDto;
import com.cvictor.fashionblogapi.dto.response.PostResponseDto;
import com.cvictor.fashionblogapi.entity.Post;
import com.cvictor.fashionblogapi.exceptions.CustomException.PostNotFoundException;
import com.cvictor.fashionblogapi.repository.PostRepository;
import com.cvictor.fashionblogapi.repository.UserRepository;
import com.cvictor.fashionblogapi.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class PostServiceImplementation implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;



    @Override
    public PostResponseDto addPost(UserRequestDto userRequestDto, PostRequestDto postRequestDto) {

            Post savedPost = postRepository.save(Post.builder()
                    .title(postRequestDto.getTitle())
                    .body(postRequestDto.getBody())
                    .build());

            return PostResponseDto.builder()
                    .title(savedPost.getTitle())
                    .postId(savedPost.getPostId())
                    .body(savedPost.getBody())
                    .build();

    }

    @Override
    public List<PostResponseDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapToPostDto).collect(Collectors.toList());

    }

//    @Override
//    public PostResponseDto updatePost(Long postId) {
//         Optional<Post> post = postRepository.findById(postId);
//
//    }

    @Override
    public void deletePost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isEmpty()) {
            throw new PostNotFoundException("No post with id " + postId);
        }
        postRepository.delete(post.get());
    }

    @Override
    public PostResponseDto getPostById(Long id) {
        Optional<Post> post = Optional.ofNullable(postRepository.findByPostId(id));
        if(post.isEmpty()) {
            throw new PostNotFoundException("No post with id");
        }
        return mapToPostDto(post.get());
    }

    public PostResponseDto mapToPostDto(Post post) {
        return PostResponseDto.builder()
                .body(post.getBody())
                .title(post.getTitle())
                .build();
    }
}
