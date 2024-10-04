package com.Student.Demo.entity;

//import com.Student.Demo.aspect.Enum.MessageType;
import com.Student.Demo.aspect.Enum.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseMessageVO {

    private String message;
    private MessageType messageType;

    public ResponseMessageVO(String message, MessageType messageType) {
        this.message = message;
        this.messageType=messageType;
    }

    // Getters and setters
}

