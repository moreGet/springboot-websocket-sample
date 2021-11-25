package com.example.websocket.chatting.controller;

import com.example.websocket.chatting.dto.ChatRoomRequestDto;
import com.example.websocket.chatting.dto.ChatRoomResponseDto;
import com.example.websocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/createRoom")
    public ResponseEntity<ChatRoomResponseDto> createRoom(
            @RequestBody @Valid ChatRoomRequestDto chatRoomReqDto) {
        return ResponseEntity.ok(chatService.createRoom(chatRoomReqDto.getName()));
    }

    @GetMapping("/findAllRoom")
    public ResponseEntity<?> findAllRoom() {
        try {
            return ResponseEntity.ok(chatService.findAllRoom());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("채팅방이 없거나 조회할 수 없습니다.");
        }
    }
}