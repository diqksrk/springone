package com.example.kang.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RequireUpdateBoard {

    @NotNull
    private Long id;

    @NotNull
    @Size(min=1, max=50)
    private String title;

    @NotNull
    @Size(min=1, max=50)
    private String content;
}
