//package com.week7.slack;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.week7.slack.Dto.ChatMessage;
//import com.week7.slack.Dto.ChatRoom;
//import com.week7.slack.Service.ChatService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//
//import java.util.logging.Logger;
//
//
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class WebSocketChatHandler extends TextWebSocketHandler {
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
//// 삭제        TextMessage textMessage = new TextMessage("Welcome chatting sever~^^ ");
//// 삭제       session.sendMessage(textMessage);
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, chatService);
//    }
//}
//
//
//
//
////@Component
////public class WebSocketChatHandler extends TextWebSocketHandler {
////
////    private final static Logger LOG = Logger.getGlobal();
////
////    @Override
////    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
////        String input = message.getPayload();
////        LOG.info(input); // 채팅 log, Message Log에 출력됨
////        // 클라이언트로 환영 메세지를 보냄
////        TextMessage textMessage = new TextMessage("welcome chatting server !");
////        session.sendMessage(textMessage);
////    }
////
////}
