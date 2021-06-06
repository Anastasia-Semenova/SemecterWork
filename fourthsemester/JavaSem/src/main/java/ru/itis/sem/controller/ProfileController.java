package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.sem.dto.UserDto;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.User;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.MasterService;
import ru.itis.sem.services.UserService;


import static ru.itis.sem.model.User.Role.ROLE_MASTER;
import static ru.itis.sem.model.User.Role.ROLE_USER;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private MasterService masterService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal UserDetailsImpl user) {
        User newUser = null;

        if (userService.findByLogin(user.getUsername()).isPresent()) {
            newUser = userService.findByLogin(user.getUsername()).get();
            model.addAttribute("user", newUser);
        }
        model.addAttribute("role_user", ROLE_USER);
        model.addAttribute("role_master", ROLE_MASTER);
        if (newUser.getRole() == ROLE_MASTER) {

            if (masterService.findByUserId(newUser.getId()).isPresent()) {
                Master newMaster = masterService.findByUserId(newUser.getId()).get();
                model.addAttribute("master", newMaster);
            }
        }
        return "profile";
    }


}
