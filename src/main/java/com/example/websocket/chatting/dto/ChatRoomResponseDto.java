package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class ChatRoomResponseDto {
    private final String roomId;
    private final String name;
    private final List<ChatUserResponseDto> users;

    public ChatRoomResponseDto(ChatRoom entity) {
        this.roomId = entity.getRoomId();
        this.name = entity.getName();
        this.users = entity.getSessions().parallelStream()
                .map(ChatUserResponseDto::new)
                .collect(Collectors.toList());
    }
}