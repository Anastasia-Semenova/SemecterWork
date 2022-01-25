package ru.itis.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itis.dto.UserDto;
import ru.itis.model.User;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

}

