package com.example.kang.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RequireCreateComment {

    @NotNull
    @Size(min = 1, max = 50)
    private String content;

    @NotNull
    private Long board_id;
}
