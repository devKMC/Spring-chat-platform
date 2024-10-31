package com.devkmc.dto;

import java.util.Map;
import jakarta.validation.constraints.NotBlank;

public class ChatRoomDto {
    @NotBlank
    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private int userCount; // 채팅방 유저 수
    private int maxUserCount; // 채팅방 최대 인원

    private String roomPassword; // 룸 비밀번호 
    private boolean secretCheck; // 채팅방 잠금 여부
    public enum ChatType { // 열거형  
        MESSAGE, RTC
    }
    private ChatType chatType; // 채팅 타입
    private Map<String, ?> userList; // 채팅방 user 목록
}

