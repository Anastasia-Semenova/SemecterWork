package ru.javalab.demo.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javalab.demo.dto.TokenPairDto;
import ru.javalab.demo.dto.UserDto;
import ru.javalab.demo.model.User;
import ru.javalab.demo.service.LoginService;
import ru.javalab.demo.service.TokenService;

import javax.annotation.security.PermitAll;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userLoginDto) {
        try {
            User user = loginService.login(userLoginDto);
            TokenPairDto tokenDto = tokenService
                    .generateTokenPair(user);
            return ResponseEntity.ok(tokenDto);
        } catch (UsernameNotFoundException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", e.getMessage());
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        }
    }
}
