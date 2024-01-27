package com.tweteroojava.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotNull(message = "userId is mandatory")
    private Long userId;

    @NotBlank(message = "text is mandatory")
    @Size(max = 280)
    private String text;
}
