package com.simbirsoft.chat.services;

import com.simbirsoft.chat.dto.MessageDto;
import com.simbirsoft.chat.dto.UserDto;
import com.simbirsoft.chat.model.User;

public interface MessageService {
    void saveMessage(MessageDto messageDto);

    MessageDto getMessage(Long id);

}
