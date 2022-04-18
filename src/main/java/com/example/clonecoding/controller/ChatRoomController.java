package com.example.clonecoding.controller;

import com.example.clonecoding.dto.ChatMessagedResponseDto;
import com.example.clonecoding.dto.ChatRoomDto;
import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatRoomJPARepository;
import com.example.clonecoding.repository.ChatRoomRepository;
import com.example.clonecoding.service.ChatSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatSerivce chatSerivce;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomJPARepository chatRoomJPARepository;

    // 모든 채팅방 목록 반환
    @GetMapping("/listlookup")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllRoom();
    }


    // 채팅방 생성
    @PostMapping("/createroom")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }

    // 특정 채팅방 조회 (추가기능)
    @GetMapping("/listlookup/{roomid}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomid) {
        return chatRoomRepository.findRoomById(roomid);
    }

    //특정 채팅방 삭제
    @DeleteMapping("/delete/{roomid}")
    public String roomDelete(@PathVariable String roomid) {
        chatRoomJPARepository.deleteByRoomId(roomid);
        return roomid;
    }

    //채팅방 내역조회
    @GetMapping("/message/{roomid}")
    @ResponseBody
    public List<ChatMessagedResponseDto> subMessage(@PathVariable String roomid){
        return chatSerivce.subMessage(roomid);
    }

}