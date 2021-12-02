package com.example.websocket.chatting.dto;

import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;


@Getter
public class ChatUserResponseDto {
    private String sessionId;
    private String currentIp;

    public ChatUserResponseDto(WebSocketSession session) {
        this.sessionId = session.getId();
        this.currentIp = session.getRemoteAddress().getAddress().getHostAddress();
    }
}
