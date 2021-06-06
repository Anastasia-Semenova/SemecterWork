package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.sem.dto.UserDto;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.User;
import ru.itis.sem.repositories.FavouritesMastersRepository;
import ru.itis.sem.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.sem.dto.UserDto.from;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private final UsersRepository usersRepository;


    public UserServiceImpl(UsersRepository usersRepository, FavouritesMastersRepository favouritesMastersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .state(userDto.getState())
                .role(userDto.getRole())
                .build());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
    @Override
    public List<UserDto> getAllMasters() {
        return from(usersRepository.findAllByRole(User.Role.ROLE_MASTER));
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {
        return from(usersRepository.findAll(PageRequest.of(page, size)).getContent());
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteUserById(id);
    }


    @Override
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public void ban(Long id) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setState(User.State.BANNED);
            usersRepository.save(user);
        }

        //usersRepository.banUser(id);
    }

    @Override
    public void unban(Long id) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setState(User.State.CONFIRMED);
            usersRepository.save(user);
        }
        //usersRepository.unbanUser(id);
    }

    @Override
    public void changeFirstname(Long id, String firstName) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setFirstName(firstName);
            usersRepository.updateFirstName(firstName, id);
        }
    }

    @Override
    public void changeLastname(Long id, String lastName) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setLastName(lastName);
            usersRepository.updateLastName(lastName, id);
        }
    }

    @Override
    public void changeLogin(Long id, String login) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setLogin(login);
            usersRepository.updateLogin(login, id);
        }
    }

    @Override
    public void changeEmail(Long id, String email) {
        Optional<User> someUser = usersRepository.findById(id);
        if (someUser.isPresent()) {
            User user = someUser.get();
            user.setEmail(email);
            usersRepository.updateEmail(email, id);
        }
    }

    @Override
    public Optional<User> findUserByMasterId(Long masterId) {
        return usersRepository.findUserByMasterId(masterId);
    }

}
