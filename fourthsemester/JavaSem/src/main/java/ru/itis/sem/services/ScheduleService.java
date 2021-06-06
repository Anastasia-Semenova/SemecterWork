package ru.itis.sem.services;

import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.model.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {
    void makeAnAppointment(ScheduleDto schedule);
    List<ScheduleDto> getAll();
    List<ScheduleDto> getAllByMasterId(Long masterId);
    List<ScheduleDto> getAllByUserId(Long userId);
    void deleteById(Long id);
}
