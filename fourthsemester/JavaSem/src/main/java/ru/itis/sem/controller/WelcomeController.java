package ru.itis.sem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class WelcomeController {

    @PermitAll
    @GetMapping(value = "/welcome")
    public String getWelcomePage() {
        return "welcome";
    }
}
