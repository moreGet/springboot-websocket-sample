package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ChatRoomResponseDto {
    private final String roomId;
    private final String name;

    public ChatRoomResponseDto(ChatRoom entity) {
        this.roomId = entity.getRoomId();
        this.name = entity.getName();
    }
}