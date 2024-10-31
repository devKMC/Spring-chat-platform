package com.devkmc.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.devkmc.handler.SignalHandler;

import lombok.RequiredArgsConstructor;

@Configuration // BEAN 수동 등록
@EnableWebSocket // 웹소켓 활성화
@RequiredArgsConstructor // 생성자를 자동으로 생성
public class WebRtcConfig implements WebSocketConfigurer{  // WebSocketConfigurer 인터페이스를 구현 (handler 가능)
    private final SignalHandler signalHandler; // private 이 클래스 안에서만 접근하여 한번 선언된 변수는 변경 안되고  

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //registerWebSocketHandlers 의 객체 = registry
        //signalHandler를 /signal 경로로 WebSocket 핸들러로 등록하고, 모든 출처에서 이 핸들러에 접근
        registry.addHandler(signalHandler, "/siglnal").setAllowedOrigins("*");
    }

    @Bean // 스프링에 빈 객체 등록 쓰기 위해서 Configuration 필요함
    public ServletServerContainerFactoryBean createWebSocketContainer () {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean(); // 인스턴스 객체 만들기
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
    


}
