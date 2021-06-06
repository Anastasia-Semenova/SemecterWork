package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;
import ru.itis.sem.repositories.MasterRepository;
import ru.itis.sem.repositories.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private final MasterRepository masterRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Optional<Master> findById(Long id) {
        return masterRepository.findById(id);
    }

    @Override
    public Optional<Master> findByUserId(Long id) {
        return masterRepository.findMasterByUserId(id);
    }

    @Override
    public int getCountOfLikes(Long masterId) {
        return masterRepository.getAllLikes(masterId);
    }

    @Override
    public List<Schedule> getAllAppointments(Long masterId) {
        return scheduleRepository.getAllAppointments(masterId);
    }




}
