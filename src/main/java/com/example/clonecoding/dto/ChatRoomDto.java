package com.example.clonecoding.dto;
import com.example.clonecoding.model.MessageType;
import lombok.*;

public class ChatRoomDto {

    @AllArgsConstructor
    @Builder
    @Data
    public static class RoomSaveRequestDto{
        String name;
    }

    @AllArgsConstructor
    @Builder
    @Data
    public static class RoomJoinRequestDto{
        MessageType type;

        String roomId;

        String sender;

        String message;
    }

    @AllArgsConstructor
    @Builder
    @Data
    public static class RoomDeleteRequestDto{
        String roomId;
    }
}
