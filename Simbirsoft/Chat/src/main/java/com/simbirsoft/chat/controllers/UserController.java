package com.simbirsoft.chat.controllers;

import com.simbirsoft.chat.dto.MessageDto;
import com.simbirsoft.chat.dto.UserDto;
import com.simbirsoft.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PermitAll
    @PostMapping("/saveUser")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok("saved user");
    }
}
