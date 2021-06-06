package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.sem.dto.MasterScheduleDto;
import ru.itis.sem.dto.ScheduleDto;
import ru.itis.sem.model.MasterSchedule;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MasterScheduleRepository extends JpaRepository<MasterSchedule, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM sem_master_schedule WHERE time = ?1")
    void deleteByTime(Date date);

    @Query(nativeQuery = true, value = "SELECT * FROM sem_master_schedule WHERE master_id = ?1")
    List<MasterSchedule> findAllById(Long masterId);
}
