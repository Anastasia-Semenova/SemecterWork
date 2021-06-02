package com.simbirsoft.chat.services;

import com.simbirsoft.chat.dto.MessageDto;
import com.simbirsoft.chat.model.Message;
import com.simbirsoft.chat.model.User;
import com.simbirsoft.chat.repositories.MessageRepository;
import com.simbirsoft.chat.repositories.RoomRepository;
import com.simbirsoft.chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.simbirsoft.chat.dto.MessageDto.from;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void saveMessage(MessageDto messageDto) {
        messageRepository.save(Message.builder()
                .text(messageDto.getText())
                .date(messageDto.getDate())
                .user(userRepository.getById(messageDto.getUserId()))
                .room(roomRepository.getById(messageDto.getRoomId()))
                .build());
    }

    @Override
    public MessageDto getMessage(Long id) {
        return from(messageRepository.getById(id));
    }


}
