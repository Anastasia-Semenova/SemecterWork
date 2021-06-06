package ru.itis.sem.services;

import ru.itis.sem.dto.FormDto;
import ru.itis.sem.model.User;

public interface SignInService {
    User singIn(FormDto user);
}
