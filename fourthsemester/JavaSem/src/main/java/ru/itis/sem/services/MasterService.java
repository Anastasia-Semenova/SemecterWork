package ru.itis.sem.services;

import ru.itis.sem.model.Master;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.Optional;

public interface MasterService {
    Optional<Master> findById(Long id);
    Optional<Master> findByUserId(Long id);
    int getCountOfLikes(Long masterId);
    List<Schedule> getAllAppointments(Long masterId);

}
