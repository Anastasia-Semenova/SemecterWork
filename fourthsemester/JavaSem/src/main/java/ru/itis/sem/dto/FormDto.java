package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormDto {
    private String login;
    private String password;

    public static FormDto from(User user) {
        return FormDto.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public static List<FormDto> from(List<User> people) {
        return people.stream()
                .map(FormDto::from)
                .collect(Collectors.toList());
    }
}
