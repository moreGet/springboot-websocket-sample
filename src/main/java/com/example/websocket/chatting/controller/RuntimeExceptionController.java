package com.example.websocket.chatting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class RuntimeExceptionController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String handleHttpError() {
        return "RUNTIME EXCEPTION ";
    }
}
