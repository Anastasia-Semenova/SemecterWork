package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem.dto.MasterScheduleDto;
import ru.itis.sem.model.MasterSchedule;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.repositories.MasterScheduleRepository;
import ru.itis.sem.repositories.ScheduleRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import static ru.itis.sem.dto.MasterScheduleDto.from;

@Service
public class MasterScheduleServiceImpl implements MasterScheduleService {

    @Autowired
    private final MasterScheduleRepository masterScheduleRepository;

    public MasterScheduleServiceImpl(ScheduleRepository scheduleRepository, MasterScheduleRepository masterScheduleRepository) {
        this.masterScheduleRepository = masterScheduleRepository;
    }

    @Override
    public void saveData(MasterScheduleDto masterScheduleDto) {
        masterScheduleRepository.save(MasterSchedule.builder()
                .id(masterScheduleDto.getId())
                .masterId(masterScheduleDto.getMasterId())
                .time(masterScheduleDto.getTime())
                .build());
    }

    @Override
    public List<MasterScheduleDto> getAll() {
        return from(masterScheduleRepository.findAll());
    }

    @Override
    public void delete(Date date) {
        masterScheduleRepository.deleteByTime(date);
    }
}
