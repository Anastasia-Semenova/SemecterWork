package com.simbirsoft.chat.controllers;

import com.simbirsoft.chat.dto.MessageDto;
import com.simbirsoft.chat.model.Message;
import com.simbirsoft.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PermitAll
    @PostMapping("/saveMessage")
    public ResponseEntity<?> signup(@RequestBody MessageDto messageDto) {
        messageService.saveMessage(messageDto);
        return ResponseEntity.ok("saved message");
    }
}
