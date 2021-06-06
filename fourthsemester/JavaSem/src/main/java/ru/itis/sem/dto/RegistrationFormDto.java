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
public class RegistrationFormDto {
    private Long id;
    private String firstName;
    //private String lastName;
    private String login;
    private String image;
    //private String email;
    private String password;
    private String confirmPassword;


    public static RegistrationFormDto from(User user) {
        return RegistrationFormDto.builder()
                .id(user.getId())
                .image(user.getImage())
                .firstName(user.getFirstName())
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
