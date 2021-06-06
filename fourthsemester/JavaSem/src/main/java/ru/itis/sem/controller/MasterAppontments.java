package ru.itis.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;
import ru.itis.sem.security.details.UserDetailsImpl;
import ru.itis.sem.services.MasterService;
import ru.itis.sem.services.UserService;

@Controller
public class MasterAppontments {

    @Autowired
    private MasterService masterService;

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/myAppointments")
    public String getAppointmentsPage(Model model, @AuthenticationPrincipal UserDetailsImpl user){
        User newUser = null;
        if (userService.findByLogin(user.getUsername()).isPresent()) {
            newUser = userService.findByLogin(user.getUsername()).get();
            model.addAttribute("master", newUser);
        }
        model.addAttribute("appointments", masterService.getAllAppointments(newUser.getId()));
        User client = null;
        //ScheduleDto schedule = masterService.getAllAppointments(newUser.getId());
//        if (userService.findByLogin(user.getUsername()).isPresent()) {
//            newUser = masterService.getUserByAppointment(newUser.getId());
//            model.addAttribute("client", newUser);
//        }
        //model.addAttribute("userLogin", );

        return "mastersAppointment";
    }
}
