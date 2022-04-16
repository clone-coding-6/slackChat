package com.example.clonecoding.controller;

import com.example.clonecoding.dto.ChatRoomDto;
import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllRoom();
    }

    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }

    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }

    //특정 채팅방 삭제
    @DeleteMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomDelte(@PathVariable ChatRoomDto.RoomDeleteRequestDto roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }

}