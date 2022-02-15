package com.example.websocket.service;

import com.example.websocket.chatting.dto.ChatRoomResponseDto;
import com.example.websocket.domain.ChatRoom.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatRoomService {
//    private final ObjectMapper objectMapper;
    private final ChatRoomRepository chatRoomRepository;

    // 레포지토리 에서 생성 후 조회
    public ChatRoomResponseDto createRoom(String name) {
        log.debug("채팅방 생성");
        return Optional.ofNullable(
                new ChatRoomResponseDto(chatRoomRepository.createRoom(name))).orElseThrow(() -> {
                    throw new IllegalArgumentException("채팅방이 생성되지 않았습니다.");
                });
    }

    // 채팅방 조회
    public List<ChatRoomResponseDto> findAllRoom() {
        log.debug("채팅방 전체 조회");
        return Optional.ofNullable(chatRoomRepository.findAllRoom().parallelStream()
                .map(ChatRoomResponseDto::new)
                .collect(Collectors.toList()))
                .filter(list -> list.size() > 0)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("채팅방이 없거나 조회할 수 없습니다.");
                });
    }

    // 채팅방 ID조회
    public ChatRoomResponseDto findById(String roomId) {
        log.debug("채팅방 ID 단일 조회");
        return Optional.ofNullable(
                chatRoomRepository.findRoomById(roomId))
                .map(ChatRoomResponseDto::new)
                .orElseThrow(() -> {
                   throw new IllegalArgumentException("해당 ID로 조회할 수 없습니다.");
                });
    }

    // 메세지를 보낼때 어떤 유형의 message 파라메터 이던간 JSON STRING 형태로 전송
//    public <T> void sendMessage(WebSocketSession session, T message) {
//        log.debug("메세지 송신");
//        try {
//            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
//        } catch (IOException ioe) {
//            log.error(ioe.getMessage(), ioe);
//        }
//    }
}