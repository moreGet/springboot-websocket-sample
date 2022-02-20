package com.example.websocket.chatting.controller;

import com.example.websocket.chatting.dto.ChatRoomResponseDto;
import com.example.websocket.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    @GetMapping("/findAllRoom")
    @ResponseBody
    public ResponseEntity<?> findAllRoom() {
        try {
            log.debug("##### 모든 채팅방 조회");
            return ResponseEntity.ok(chatService.findAllRoom());
        } catch (Exception e) {
            log.debug(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        log.debug("##### 채팅방 입장 {}", roomId);
        String redirectUrl = "/chat/roomdetail";

        chatService.findById(roomId); // 채팅방 조회
        model.addAttribute("roomId", roomId);

        return redirectUrl;
    }

    // 채팅방 생성
    @PostMapping("/createRoom")
    @ResponseBody
    public ResponseEntity<ChatRoomResponseDto> createRoom(
            @RequestBody @Valid String roomId) {
        log.debug("##### 채팅방 생성 {}", roomId);
        return ResponseEntity.ok(chatService.createRoom(roomId));
    }

    // 특정 채팅방 조회
    @PostMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoomResponseDto roomInfo(@PathVariable String roomId) {
        log.debug("##### 특정 채팅방 조회 {}", roomId);
        return chatService.findById(roomId);
    }
}