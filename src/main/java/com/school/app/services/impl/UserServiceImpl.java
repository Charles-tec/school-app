package com.school.app.services.impl;

import com.school.app.dtos.UserDto;
import com.school.app.models.User;
import com.school.app.repositories.UserRepo;
import com.school.app.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    User buildUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
    UserDto buildUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        final var user = buildUser(userDto);
        final var savedUser = userRepo.save(user);
        return buildUserDto(savedUser);
    }
}
