package com.example.websocket.chatting.controller;

import com.example.websocket.chatting.dto.ChatMessageRequestDto;
import com.example.websocket.commonEnumType.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessageRequestDto messageRequestDto) {
        if (MessageType.JOIN.equals(messageRequestDto.getType())) {
            messageRequestDto.setMessage(messageRequestDto.getSender() + "님이 입장 하셨습니다.");
        }

        log.debug("MSG_DTO : {}", messageRequestDto);
        messagingTemplate.convertAndSend("/sub/chat/room/" + messageRequestDto.getRoomId(), messageRequestDto);
    }
}