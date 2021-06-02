package com.simbirsoft.chat.repositories;

import com.simbirsoft.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
