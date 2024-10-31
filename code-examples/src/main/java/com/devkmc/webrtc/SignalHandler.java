import org.springframework.web.socket.WebSocketHandler;

public class SignalHandler implements WebSocketHandler {
    // WebSocketHandler 인터페이스의 모든 메서드를 구현해야 합니다.
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 연결이 설정된 후 수행할 작업
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // 메시지를 처리하는 코드
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 전송 오류 처리 코드
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 연결이 닫힌 후 수행할 작업
    }

    @Override
    public boolean supportsPartialMessages() {
        return false; // 부분 메시지를 지원하는지 여부
    }
}
