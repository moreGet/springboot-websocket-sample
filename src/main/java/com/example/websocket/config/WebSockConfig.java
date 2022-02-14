package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration // 설정 클래스
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Stomp를 사용하기 위해 WebSocketMessageBrokerConfigurer를 선언후 messageBroker를 구현 합니다.
     * pub/sub 메세징을 구현하기 위해 메세지를 발행하는 요청의 prefix는 /pub로 시작하도록 설정하고 메세지를
     * 구독하는 요청의 prefix는 /sub로 시작하도록 설정합니다.
     * 추가로 stomp websocket을 이용하기위한 endpoint는 /ws-stomp로 설정 합니다.
     * 현재 설정 값에 의한 개발서버 주소 : ws://localhost:8080/ws-stomp
     */

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp")
                .setAllowedOrigins("*")
                .withSockJS(); // socketJs 사용
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
