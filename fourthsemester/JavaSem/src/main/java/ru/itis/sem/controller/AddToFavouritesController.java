package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem.model.User;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.FavouritesMastersService;
import ru.itis.sem.services.MasterService;
import ru.itis.sem.services.UserService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Controller
public class AddToFavouritesController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavouritesMastersService favouritesMastersService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/addToFavourites/{master-id}")
    public String getAddToFavourites(@PathVariable("master-id") Long masterId, Model model){
        model.addAttribute("favourites", favouritesMastersService.findFavouritesByMasterId(masterId));
        System.out.println(masterId);
        return "redirect:/profile/addToFavourites}";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/addToFavourites/{master-id}")
    public String addToFavourites(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("master-id") Long masterId, Model model) {
        User newUser;
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            newUser = userService.findByLogin(user.getUsername()).get();
            favouritesMastersService.addToFavourites(newUser.getId(), masterId);
        }
        return "redirect:/masters";
    }
}
