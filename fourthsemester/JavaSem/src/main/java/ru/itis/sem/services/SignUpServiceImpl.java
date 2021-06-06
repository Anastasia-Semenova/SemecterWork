package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.sem.dto.RegistrationFormDto;
import ru.itis.sem.dto.UserDto;
import ru.itis.sem.model.User;
import ru.itis.sem.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;

    private final UserService usersService;

    @Autowired
    private UsersRepository usersRepository;

    public SignUpServiceImpl(UserService usersService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }

    @Override
    public void signUp(RegistrationFormDto form) {

        UserDto newUser = UserDto.builder()
                .firstName(form.getFirstName())
                .login(form.getLogin())
                .password(passwordEncoder.encode(form.getPassword()))
                .state(User.State.CONFIRMED)
                .role(User.Role.ROLE_USER)
                .build();

        usersService.addUser(newUser);
    }

    @Override
    public User signUpWithPhoto(RegistrationFormDto form) {
        User newUser = User.builder()
                .firstName(form.getFirstName())
                .login(form.getLogin())
                .image(form.getImage())
                .password(passwordEncoder.encode(form.getPassword()))
                .state(User.State.CONFIRMED)
                .role(User.Role.ROLE_USER)
                .build();

        //usersService.addUser(newUser);
        return usersRepository.save(newUser);
    }
}

