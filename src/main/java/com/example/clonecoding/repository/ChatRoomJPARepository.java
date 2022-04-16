package com.example.clonecoding.repository;

import com.example.clonecoding.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomJPARepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> deleteByRoomId(String roomid);

}
