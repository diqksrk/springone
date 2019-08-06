package com.example.kang.dto;

import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RequireCreateBoard {

    @NotNull
    @Size(min=1, max=50)
    private String title;

    @NotNull
    @Size(min=1, max=50)
    private String content;
}
