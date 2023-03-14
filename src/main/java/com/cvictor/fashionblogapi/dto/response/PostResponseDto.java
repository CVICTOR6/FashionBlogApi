package com.cvictor.fashionblogapi.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder

public class PostResponseDto {
    private Long postId;
    private String title;

    private String body;
}
