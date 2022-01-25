package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String name;

    private String surname;


}
