package com.service.usermanagement.mappers;

import com.service.usermanagement.dtos.UserCreateDto;
import com.service.usermanagement.dtos.UserDto;
import com.service.usermanagement.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> userListToUserDtoList(List<User> user);
    UserDto userToUserDto(User user);
    User userCreateDtoToUser(UserCreateDto user);
}
