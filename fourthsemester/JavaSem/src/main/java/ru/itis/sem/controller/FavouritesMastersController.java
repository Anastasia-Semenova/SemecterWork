package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.sem.dto.MasterScheduleDto;
import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.dto.TimeTransferDto;
import ru.itis.sem.model.MasterSchedule;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;
import ru.itis.sem.repositories.ScheduleRepository;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.FavouritesMastersService;
import ru.itis.sem.services.MasterScheduleService;
import ru.itis.sem.services.ScheduleService;
import ru.itis.sem.services.UserService;

import javax.annotation.security.PermitAll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Controller
public class FavouritesMastersController {

    @Autowired
    private UserService userService;

    @Autowired
    private MasterScheduleService masterScheduleService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private FavouritesMastersService favouritesMastersService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/favouritesMasters")
    public String getFavouriteMastersPage(@AuthenticationPrincipal UserDetailsImpl user,  Model model) {
        User newUser = null;
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            newUser = userService.findByLogin(user.getUsername()).get();
            if(favouritesMastersService.findFavouritesByUserId(newUser.getId()).isEmpty()){
                model.addAttribute("favouriteMasterList", null);
            }else {
                model.addAttribute("favouriteMasterList", favouritesMastersService.findFavouritesByUserId(newUser.getId()));
            }
            }
        //model.addAttribute(userService.findUserByMasterId());
        return "favouritesMasters";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/delete/{master_id}")
    public String getDeleteFavourites(@AuthenticationPrincipal UserDetailsImpl user,  Model model, @PathVariable("master_id") Long masterId){
        User newUser = null;
        if(userService.findByLogin(user.getUsername()).isPresent()) {
            newUser = userService.findByLogin(user.getUsername()).get();
        }
        favouritesMastersService.deleteFavouritesById(masterId);
        return "favouritesMasters";
    }
}
