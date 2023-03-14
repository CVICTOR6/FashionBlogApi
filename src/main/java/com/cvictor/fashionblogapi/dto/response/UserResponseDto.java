package com.cvictor.fashionblogapi.dto.response;

import com.cvictor.fashionblogapi.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String name;
    private Role role;
}
