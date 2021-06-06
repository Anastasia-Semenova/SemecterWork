package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.User;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.FavouritesMastersService;
import ru.itis.sem.services.MasterService;
import ru.itis.sem.services.UserService;

import static ru.itis.sem.model.User.Role.ROLE_MASTER;
import static ru.itis.sem.model.User.Role.ROLE_USER;

@Controller
public class MastersProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private MasterService masterService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile/{user-id}")
    public String getMasterProfile(Model model, @AuthenticationPrincipal UserDetailsImpl user, @PathVariable("user-id") Long id) {
        User newUser = null;

        if (userService.findById(id).isPresent()) {
            newUser = userService.findById(id).get();
            model.addAttribute("user", newUser);
        }
//        if(userService.findByLogin(user.getUsername()).isPresent()) {
//            newUser = userService.findByLogin(user.getUsername()).get();
//            model.addAttribute("user", newUser);
//        }
        model.addAttribute("role_user", ROLE_USER);
        model.addAttribute("role_master", ROLE_MASTER);
        Master newMaster = null;
        if (newUser.getRole() == ROLE_MASTER) {

            if (masterService.findByUserId(id).isPresent()) {
                newMaster = masterService.findByUserId(id).get();
                model.addAttribute("master", newMaster);
                model.addAttribute("liked", masterService.getCountOfLikes(newMaster.getId()));
            }
        }
        return "masterProfile";
    }
}
