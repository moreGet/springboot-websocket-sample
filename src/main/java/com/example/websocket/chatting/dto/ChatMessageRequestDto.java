package com.example.websocket.chatting.dto;

import com.example.websocket.commonEnumType.MessageType;
import com.example.websocket.domain.ChatMessage.ChatMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessageRequestDto {
    private MessageType type;  // 메세지 타입
    private String roomId; // 방번호
    private String sender; // 메세지 보낸사람
    private String message; // 메세지

    @Builder
    public ChatMessageRequestDto(MessageType type, String roomId, String sender, String message) {
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
    }

    public ChatMessage toEntity() {
        return ChatMessage.builder()
                .type(this.type)
                .roomId(this.roomId)
                .sender(this.sender)
                .message(this.message)
                .build();
    }
}