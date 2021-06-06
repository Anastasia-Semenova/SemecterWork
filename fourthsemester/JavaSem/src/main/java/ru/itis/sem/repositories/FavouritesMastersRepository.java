package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.sem.model.FavouritesMasters;

import java.util.List;

@Repository
public interface FavouritesMastersRepository extends JpaRepository<FavouritesMasters, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into sem_favourite_masters (user_id, master_id) values (:userId, :masterId)")
    void saveFavourites(@Param("userId") Long userId, @Param("masterId") Long masterId);

    @Query(nativeQuery = true, value = "select from sem_favourite_masters where master_id = ?1")
    FavouritesMasters findByMasterId(Long id);

    @Query(nativeQuery = true, value = "select * from sem_favourite_masters where user_id = ?1")
    List<FavouritesMasters> findByUserId(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from sem_favourite_masters where id = ?1")
    void deleteById(Long id);
}
