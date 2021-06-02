package com.simbirsoft.chat.services;

import com.simbirsoft.chat.dto.UserDto;
import com.simbirsoft.chat.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);

}
