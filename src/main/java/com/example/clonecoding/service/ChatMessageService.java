package com.example.clonecoding.service;

import com.example.clonecoding.dto.ChatMessageDto;
import com.example.clonecoding.model.MessageType;
import com.example.clonecoding.pubsub.RedisPublisher;
import com.example.clonecoding.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatRoomRepository chatRoomRepository;
    private final RedisPublisher redisPublisher;
    public void joinMessage(ChatMessageDto.Request message) {
        if (MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
    }
}
