package com.example.websocket.domain.ChatRoom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoom {
    private String roomId;
    private String name;

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    /**
     * pub/sub 방식을 이용 한다면 세션관리가 필요없고 발송부 구현도 자동 구현되므로
     * 해당 DOMAIN을 간소화 시킬 수 있다.
     */
}