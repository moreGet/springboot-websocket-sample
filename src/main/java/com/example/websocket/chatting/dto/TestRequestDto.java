package com.example.websocket.chatting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TestRequestDto {
    private String ldtDate;
    private String name;

    @Builder
    public TestRequestDto(String ldtDate, String name) {
        this.ldtDate = ldtDate;
        this.name = name;
    }
}