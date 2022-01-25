package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplePdfDto {

    private String type;

    private String filename;

    private UserDto userDto;

}
