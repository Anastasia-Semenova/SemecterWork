package ru.itis.sem.services;

import ru.itis.sem.dto.MasterScheduleDto;

import java.util.Date;
import java.util.List;

public interface MasterScheduleService {
    void saveData(MasterScheduleDto masterScheduleDto);
    List<MasterScheduleDto> getAll();
    void delete(Date date);
}
