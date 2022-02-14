package com.example.websocket.chatting.controller;

import com.example.websocket.chatting.dto.ChatRoomRequestDto;
import com.example.websocket.chatting.dto.ChatRoomResponseDto;
import com.example.websocket.domain.ChatRoom.ChatRoom;
import com.example.websocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    @PostMapping("/createRoom")
    @ResponseBody
    public ResponseEntity<ChatRoomResponseDto> createRoom(
            @RequestBody @Valid ChatRoomRequestDto chatRoomReqDto) {
        return ResponseEntity.ok(chatService.createRoom(chatRoomReqDto.getName()));
    }

    @GetMapping("/findAllRoom")
    @ResponseBody
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

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    // 특정 채팅방 조회
//    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.POST)
    @PostMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        log.debug("##### 방 생성 동작");
        return chatService.findById(roomId);
    }
}