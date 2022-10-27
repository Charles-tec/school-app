package com.school.app.services;

import com.school.app.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto save(UserDto userDto);

}
