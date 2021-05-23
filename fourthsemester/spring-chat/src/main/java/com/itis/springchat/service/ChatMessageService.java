package com.itis.springchat.service;

import com.itis.springchat.model.ChatMessage;
import com.itis.springchat.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository messageRepository;

    public ChatMessage save(ChatMessage message){
        return messageRepository.save(message);
    }
}
