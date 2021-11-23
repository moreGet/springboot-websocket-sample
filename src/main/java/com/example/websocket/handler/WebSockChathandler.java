package com.example.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class WebSockChathandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload(); // Client로 부터 받은 메세지 내용을 String 객체로 반환
        log.info("payload {}", payload); // Client로 부터 받은 메세지 내용을 LOG출력
        TextMessage textMessage = new TextMessage("Welcome chatting server~"); // TextMessage 객체로 Payload 작성
        session.sendMessage(textMessage); // 현재 접속한 클라이언트 세션 모두에게 브로드캐스팅
    }
}
