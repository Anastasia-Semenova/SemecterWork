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
import ru.itis.sem.services.MasterScheduleService;
import ru.itis.sem.services.ScheduleService;
import ru.itis.sem.services.UserService;

import javax.annotation.security.PermitAll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MastersController {

    @Autowired
    private UserService userService;

    @Autowired
    private MasterScheduleService masterScheduleService;

    @Autowired
    private ScheduleService scheduleService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/masters")
    public String getMastersPage(Model model) {
        model.addAttribute("masterList", userService.getAllMasters());
        model.addAttribute("masterDateList", masterScheduleService.getAll());
        return "masters";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/schedule/{id}")
    public String writeUsers(@PathVariable("id") Long id, TimeTransferDto timeTransferDto, @AuthenticationPrincipal UserDetailsImpl user) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy, HH:mm:ss.SSS");
        Date docDate= format.parse(timeTransferDto.getDate());

        User newUser = null;

        if (userService.findById(id).isPresent()) {
            newUser = userService.findById(id).get();
        }

        scheduleService.makeAnAppointment(ScheduleDto.builder()
                .masterId(id)
                .userId(newUser.getId())
                .time(docDate)
                .build());
        masterScheduleService.delete(docDate);
        return "redirect:/masters";
    }
}
