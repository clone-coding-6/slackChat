package com.example.clonecoding.repository;

import com.example.clonecoding.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomJpaRepository extends JpaRepository<ChatRoom , Long> {
    ChatRoom findChatRoomByChatRoomId(String chatRoomId);
}
