package com.example.websocket.domain.ChatRoom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoom> chatRooms;

    // 서비스가 DI에 올라가면서 처음에 실행되는 METHOD
    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    // 채팅방 생 성
    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .name(name)
                .build();

        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }

    // 모든 채팅방 조회
    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> roomList = new ArrayList<ChatRoom>(chatRooms.values());
        Collections.reverse(roomList); // 채팅방 내림차순
        return roomList;
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }
}
