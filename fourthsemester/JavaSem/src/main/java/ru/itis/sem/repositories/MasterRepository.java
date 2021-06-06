package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

    @Query(nativeQuery = true, value = "select * from sem_master left join sem_user on sem_master.user_id=sem_user.id where sem_user.id = ?")
    Optional<Master> findMasterByUserId(Long id);

    @Query(nativeQuery = true, value = "select count(master_id) from sem_favourite_masters where master_id=?1")
    int getAllLikes(Long masterId);




}
