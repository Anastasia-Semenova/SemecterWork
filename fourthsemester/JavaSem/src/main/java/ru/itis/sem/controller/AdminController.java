package ru.itis.sem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem.services.UserService;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/ban/{id}")
    public String banUsers(@PathVariable("id") Long id) {
        userService.ban(id);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/unban/{id}")
    public String unbanUsers(@PathVariable("id") Long id) {
        System.out.println(id);
        userService.unban(id);
        return "redirect:/admin";
    }
}

