package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;

@Slf4j
@Getter
public class ChatRoomResponseDto {
    private final String roomId;
    private final String name;
    private HashSet<WebSocketSession> sessions;

    public ChatRoomResponseDto(ChatRoom entity) {
        this.roomId = entity.getRoomId();
        this.name = entity.getName();
        this.sessions = (HashSet<WebSocketSession>) entity.getSessions();

        entity.getSessions().stream().forEach(session -> {
            log.debug("SESSION_ID : {}", session.getId());
            log.debug("SESSION_IP : {}", session.getRemoteAddress());
        });
    }
}