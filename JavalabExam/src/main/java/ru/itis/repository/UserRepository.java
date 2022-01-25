package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}