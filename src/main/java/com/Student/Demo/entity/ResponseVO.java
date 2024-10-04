package com.Student.Demo.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Builder

public class ResponseVO<T> {
    private ResponseMessageVO message;
    private T data;

    public ResponseVO(ResponseMessageVO message, T data) {
        this.message = message;
        this.data = data;
    }
}

