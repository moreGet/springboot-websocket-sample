package com.example.websocket.chatting.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RUNTIME ERROR HANDLE
 */
@Slf4j
@ControllerAdvice
public class RuntimeExceptionController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String handleRuntimeException(RuntimeException e) {
        log.debug("#### DEBUG {}", e.getMessage());
        return "RUNTIME EXCEPTION ";
    }
}
