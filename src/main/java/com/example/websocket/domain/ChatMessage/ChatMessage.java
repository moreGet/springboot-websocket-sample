package com.example.websocket.domain.ChatMessage;

import com.example.websocket.commonEnumType.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatMessage {
    private MessageType type;  // 메세지 타입
    private String roomId; // 방번호
    private String sender; // 메세지 보낸사람
    private String message; // 메세지

    @Builder
    public ChatMessage(MessageType type, String roomId, String sender, String message) {
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
    }
}
