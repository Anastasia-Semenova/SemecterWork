package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByLogin(String login);
    void deleteUserById(Long id);
    List<User> findAllByRole(User.Role role);

    @Query(nativeQuery = true, value = "update sem_user set state = 'BANNED' where id = ?1")
    void banUser(Long id);

    @Query(nativeQuery = true, value = "update sem_user set state = 'CONFIRMED' where id = ?1")
    void unbanUser(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update sem_user set first_name = ? where id = ?")
    void updateFirstName(String firstName, Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update sem_user set last_name = ? where id = ?")
    void updateLastName(String firstName, Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update sem_user set login = ? where id = ?")
    void updateLogin(String firstName, Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update sem_user set email = ? where id = ?")
    void updateEmail(String firstName, Long id);

    @Query(nativeQuery = true, value = "select * from sem_master left join sem_user on sem_master.user_id=sem_user.id where sem_master.id = ?")
    Optional<User> findUserByMasterId(Long id);


}
