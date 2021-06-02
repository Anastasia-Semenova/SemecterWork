package com.simbirsoft.chat.services;

import com.simbirsoft.chat.dto.UserDto;
import com.simbirsoft.chat.model.User;
import com.simbirsoft.chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.simbirsoft.chat.dto.UserDto.from;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .state(userDto.getState())
                .build());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAll());
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
