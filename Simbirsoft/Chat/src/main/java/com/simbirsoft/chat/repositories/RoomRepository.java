package com.simbirsoft.chat.repositories;

import com.simbirsoft.chat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
