package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.sem.dto.MasterScheduleDto;
import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<ScheduleDto> findAllById(Long id);


    @Query(nativeQuery = true, value = "select * from sem_schedule where master_id=?1")
    List<Schedule> getAllAppointments(Long masterId);

}
