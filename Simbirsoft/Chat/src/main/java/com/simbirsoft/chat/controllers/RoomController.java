package com.simbirsoft.chat.controllers;

import com.simbirsoft.chat.dto.MessageDto;
import com.simbirsoft.chat.dto.RoomDto;
import com.simbirsoft.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PermitAll
    @PostMapping("/addRoom")
    public ResponseEntity<?> signup(@RequestBody RoomDto roomDto) {
        roomService.save(roomDto);
        return ResponseEntity.ok("saved room");
    }
}
