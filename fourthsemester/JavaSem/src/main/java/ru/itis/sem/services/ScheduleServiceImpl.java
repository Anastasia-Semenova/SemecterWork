package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.repositories.ScheduleRepository;

import java.util.Date;
import java.util.List;

import static ru.itis.sem.dto.ScheduleDto.from;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void makeAnAppointment(ScheduleDto schedule) {
        scheduleRepository.save(Schedule.builder()
                .id(schedule.getId())
                .masterId(schedule.getMasterId())
                .userId(schedule.getUserId())
                .time(schedule.getTime())
                .state(schedule.getState())
                .build());
    }

    @Override
    public List<ScheduleDto> getAll() {
        return from(scheduleRepository.findAll());
    }

    @Override
    public List<ScheduleDto> getAllByMasterId(Long masterId) {
        return scheduleRepository.findAllById(masterId);
    }

    @Override
    public List<ScheduleDto> getAllByUserId(Long userId) {
        return scheduleRepository.findAllById(userId);
    }

    @Override
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
