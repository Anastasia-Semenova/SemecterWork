package com.itis.springchat.controller;

import com.itis.springchat.model.ChatMessage;
import com.itis.springchat.model.ChatRoom;
import com.itis.springchat.service.ChatMessageService;
import com.itis.springchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void chat(@Payload ChatMessage message){
        ChatRoom chatRoom = chatService.getOrCreate(message.getSenderId(), message.getRecipientId());
        message.setChatRoom(chatRoom);
        message = chatMessageService.save(message);

        messagingTemplate.convertAndSendToUser(message.getRecipientId(), "/queue/messages", message);
    }
}
