package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem.dto.RegistrationFormDto;
import ru.itis.sem.model.User;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.UserService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Controller
public class ChangeFormController {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/changeFirstName")
    public String getChangeFirstnamePage(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            model.addAttribute("user", newUser);
        }
        return "changeFirstname";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/changeFirstname")
    public String changeFirstname(@Valid String firstName, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            userService.changeFirstname(newUser.getId(), firstName);
        }
        return "redirect:/profile";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/changeLastName")
    public String getChangeLastnamePage(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            model.addAttribute("user", newUser);
        }
        return "changeLastname";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/changeLastname")
    public String changeLastname(@Valid String lastName, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            userService.changeLastname(newUser.getId(), lastName);
        }
        return "redirect:/profile";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/changeEmail")
    public String getChangeEmailPage(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            model.addAttribute("user", newUser);
        }
        return "changeEmail";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/changeEmail")
    public String changeEmail(@Valid String email, @AuthenticationPrincipal UserDetailsImpl user) {
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            User newUser = userService.findByLogin(user.getUsername()).get();
            userService.changeEmail(newUser.getId(), email);
        }
        return "redirect:/profile";
    }
}
