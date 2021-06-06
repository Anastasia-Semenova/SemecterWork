package ru.itis.sem.services;

import ru.itis.sem.dto.RegistrationFormDto;
import ru.itis.sem.model.User;

public interface SignUpService {
    void signUp(RegistrationFormDto form);
    User signUpWithPhoto(RegistrationFormDto form);
}
