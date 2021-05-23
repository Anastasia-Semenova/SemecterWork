package com.itis.springchat.service;

import com.itis.springchat.model.ChatRoom;
import com.itis.springchat.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatRoom getOrCreate(String sender, String recipient){
        ChatRoom chatRoom=chatRoomRepository.findByUsers(sender, recipient);
        if(chatRoom==null){
            ChatRoom newChatRoom = new ChatRoom();
            newChatRoom.setUser1Id(sender);
            newChatRoom.setUser2Id(recipient);
            return chatRoomRepository.save(newChatRoom);
        }
        return chatRoom;
    }
}
