package com.cvictor.fashionblogapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommentResponseDto {
    private String commentBody;
    private String comments;
}
