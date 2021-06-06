package ru.itis.sem.services;

import ru.itis.sem.dto.UserDto;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(UserDto userDto);

    List<UserDto> getAllUsers();
    List<UserDto> getAllMasters();

    List<UserDto> getAllUsers(int page, int size);

    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
    void deleteUser(Long id);


    void saveUser(User user);

    void changeFirstname(Long id, String firstName);
    void changeLastname(Long id, String lastName);
    void changeLogin(Long id, String login);
    void changeEmail(Long id, String email);


    void ban(Long id);
    void unban(Long id);

    Optional<User> findUserByMasterId(Long masterId);

}
