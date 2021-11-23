package com.example.websocket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@RequiredArgsConstructor // 생성자 주입 방식을 위해 선언
@EnableWebSocket // 웹소켓 활성화
@Configuration // 설정 클래스
public class WebSockConfig implements WebSocketConfigurer {
    private final WebSocketHandler webSocketHandler;

    /**
     * 1. WebSocket 접속을 위해 엔드포인트는 /ws/chat로 설정
     * 2. 도메인이 다른 서버에서도 접속 가능 하도록 CORS : setAllowedOrigins("*") 처리
     * 3. 클라이언트가 ws://localhost:8080/ws/chat 으로 커넥션을 연결하고 메세지 통신을 하기 위한 기본 준비 끝.
     * 4. 아직 화면 구현이 안되어 있으므로 크롬 플러그인인 웹소켓 TEST 클라이언트 설치
     * 5. https://chrome.google.com/webstore/detail/websocket-test-client/fgponpodhbmadfljofbimhhlengambbn/related
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}
