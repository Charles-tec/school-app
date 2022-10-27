package com.school.app.services;

import com.school.app.dtos.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponseDto login(String username, String password);
}
