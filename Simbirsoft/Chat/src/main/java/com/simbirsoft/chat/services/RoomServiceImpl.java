package com.simbirsoft.chat.services;

import com.simbirsoft.chat.dto.RoomDto;
import com.simbirsoft.chat.model.Room;
import com.simbirsoft.chat.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void save(RoomDto roomDto) {
        roomRepository.save(Room.builder()
                .user(roomDto.getUseruserList())
                .build());
    }
}
