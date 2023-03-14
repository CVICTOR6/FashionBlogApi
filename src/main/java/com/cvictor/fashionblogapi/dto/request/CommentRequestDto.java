package com.cvictor.fashionblogapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommentRequestDto {
    private String commentBody;
    private String comments;
}
