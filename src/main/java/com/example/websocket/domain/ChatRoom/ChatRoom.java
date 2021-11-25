package com.example.websocket.domain.ChatRoom;

import com.example.websocket.chatting.dto.ChatMessageRequestDto;
import com.example.websocket.commonEnumType.MessageType;
import com.example.websocket.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleActions(WebSocketSession session, ChatMessageRequestDto chatMessage, ChatService chatService) {
        if (chatMessage.getType().equals(MessageType.ENTER)) { // 채팅방 접속 메세지 일때 해당 채팅방에 세션 저장
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장 했습니다.");
        }

        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> {
            chatService.sendMessage(session, message);
        });
    }
}