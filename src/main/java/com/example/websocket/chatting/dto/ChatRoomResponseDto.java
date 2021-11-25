package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;

@Getter
public class ChatRoomResponseDto {
    private final String roomId;
    private final String name;
    private Set<WebSocketSession> sessions;

    public ChatRoomResponseDto(ChatRoom entity) {
        this.roomId = entity.getRoomId();
        this.name = entity.getName();
        this.sessions = entity.getSessions();
    }
}