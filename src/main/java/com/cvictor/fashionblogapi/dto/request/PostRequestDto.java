package com.cvictor.fashionblogapi.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PostRequestDto {
    private String title;

    private String body;

}
