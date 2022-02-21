package com.example.websocket.chatting.dto;

import com.example.websocket.domain.ChatRoom.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//{
//        "type":"ENTER",
//        "roomId":"9e648d2d-5e2e-42b3-82fc-b8bef8111cbe",
//        "sender":"happydaddy",
//        "message":""
//}

@NoArgsConstructor
@Getter
public class ChatRoomRequestDto {
    @NotNull
    @NotEmpty
    private String roomId;
    @NotNull
    @NotEmpty
    private String roomName;

    @Builder
    public ChatRoomRequestDto(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public ChatRoom toEntity() {
        return ChatRoom.builder()
                .name(this.roomName)
                .roomId(this.roomId)
                .build();
    }
}