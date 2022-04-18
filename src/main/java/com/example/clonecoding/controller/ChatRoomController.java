package com.example.clonecoding.controller;

import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatRoomRepository;
import com.example.clonecoding.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "roomdetail";
    }

    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllRoom();
    }

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    // 채팅방 생성
    @PostMapping("/createroom")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name){
        return chatRoomService.createRoom(name);
    }

    //특정 채팅방 삭제
    @DeleteMapping("/delete/{roomId}")
    @ResponseBody
    public void roomDelete(@PathVariable String roomId) {
        chatRoomService.delete(roomId);
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }
}