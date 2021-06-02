package com.simbirsoft.chat.repositories;

import com.simbirsoft.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
