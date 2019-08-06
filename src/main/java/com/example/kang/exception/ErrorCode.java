package com.example.kang.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BOARD_NOT_EXIST(400, "M002", "존재하지 않는 게시글 입니다.");


    private int status;
    private final String code;
    private final String message;


    }
