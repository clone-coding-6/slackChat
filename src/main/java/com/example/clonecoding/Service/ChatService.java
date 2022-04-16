//package com.week7.slack.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.week7.slack.Dto.ChatRoom;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.util.*;
//
////@Slf4j
////@RequiredArgsConstructor
////@Service
////public class ChatService {
////
////    private final ObjectMapper objectMapper;
////    //채팅방 조회를 위해 서버에 생선된 모든 채팅방을 MAP에 모아둔 구조체
////    private Map<String, ChatRoom> chatRooms;
////
////    @PostConstruct
////    private void init() {
////        chatRooms = new LinkedHashMap<>();
////    }
////
////    public List<ChatRoom> findAllRoom() {
////        return new ArrayList<>(chatRooms.values());
////    }
////
////    public ChatRoom findRoomById(String roomId) {
////        return chatRooms.get(roomId);
////    }
////
////    public ChatRoom createRoom(String name) {
////        String randomId = UUID.randomUUID().toString();
////        ChatRoom chatRoom = ChatRoom.builder()
////                .roomId(randomId)
////                .name(name)
////                .build();
////        chatRooms.put(randomId, chatRoom);
////        return chatRoom;
////    }
////
////    // 지정한 Websocket 세션에 메시지를 발송.
////    public <T> void sendMessage(WebSocketSession session, T message) {
////        try {
////            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
////        } catch (IOException e) {
////            log.error(e.getMessage(), e);
////        }
////    }
////}
