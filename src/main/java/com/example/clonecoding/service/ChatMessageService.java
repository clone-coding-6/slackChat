package com.example.clonecoding.service;

import com.example.clonecoding.dto.ChatMessageDto;
import com.example.clonecoding.model.MessageType;
import com.example.clonecoding.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatRoomRepository chatRoomRepository;
    public void joinMessage(ChatMessageDto.Request message) {
        if (MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
    }
}
