package com.week7.slack.controller;

import com.week7.slack.Dto.ChatMessage;
import com.week7.slack.Dto.ChatRoom;
import com.week7.slack.RedisPublisher;
import com.week7.slack.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        // Websocket에 발행된 메시지를 redis로 발행한다(publish)
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
    }
}



//@RequiredArgsConstructor
//@Controller
//public class ChatController {
//
//    private final SimpMessageSendingOperations messagingTemplate;
//
//    //Websocket으로 들어오는 메세지 발행을 처리
//    //클라이언트에서는 /pub/chat/message로 발행 요청하면 controller가 받아서 처리.
//    @MessageMapping("/chat/message")
//    public void message(ChatMessage message) {
//        //JOIN ??
//        if (ChatMessage.MessageType.JOIN.equals(message.getType()))
//            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
//        //기존에 핸들러 역할을대신함.
//        //Topic의 역할
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//    }
//}
