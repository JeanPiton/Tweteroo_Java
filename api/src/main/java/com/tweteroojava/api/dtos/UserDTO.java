package com.tweteroojava.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "Avatar is mandatory")
    private String avatar;

    @NotBlank(message = "Username is mandatory")
    private String username;   
}
