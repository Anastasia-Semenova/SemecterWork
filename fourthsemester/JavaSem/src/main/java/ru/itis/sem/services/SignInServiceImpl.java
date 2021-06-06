package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.sem.dto.FormDto;
import ru.itis.sem.model.User;
import ru.itis.sem.repositories.UsersRepository;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User singIn(FormDto user) {
        User auth = usersRepository.findByLogin(user.getLogin()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return passwordEncoder
                .matches(passwordEncoder.encode(user.getPassword()), auth.getPassword()) ? auth : null;
    }
}
