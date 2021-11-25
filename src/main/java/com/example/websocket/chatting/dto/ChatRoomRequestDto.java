package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class ChatRoomRequestDto {
    @NotNull @NotEmpty
    private String roomId;
    @NotNull @NotEmpty
    private String name;

    @Builder
    public ChatRoomRequestDto(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public ChatRoom toEntity() {
        return ChatRoom.builder()
                .name(this.name)
                .roomId(this.roomId)
                .build();
    }
}