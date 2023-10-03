package com.service.usermanagement.services;

import com.service.usermanagement.dtos.UserCreateDto;
import com.service.usermanagement.dtos.UserDto;
import com.service.usermanagement.dtos.UserUpdateDto;
import com.service.usermanagement.exceptions.UserNotFoundException;
import com.service.usermanagement.mappers.UserMapper;
import com.service.usermanagement.models.User;
import com.service.usermanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return UserMapper.INSTANCE.userListToUserDtoList(userRepository.findAll());
    }

    public UserDto getUserById(@NotNull @Min(1) Long id) {
        log.info("UserService: Getting user with id {}", id);
        return UserMapper.INSTANCE.userToUserDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    public UserDto createUser(@Valid UserCreateDto user) {
        return UserMapper.INSTANCE.userToUserDto(userRepository.save(UserMapper.INSTANCE.userCreateDtoToUser(user)));
    }

    public UserDto updateUser(@NotNull @Min(1) Long id, @Valid UserUpdateDto user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());

        return UserMapper.INSTANCE.userToUserDto(userRepository.save(existingUser));
    }

    public void deleteUser(@NotNull @Min(1) Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);
    }
}

