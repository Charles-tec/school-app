package com.school.app.services.impl;

import com.school.app.exceptions.InvalidLoginException;
import com.school.app.repositories.UserRepo;
import io.micrometer.core.instrument.util.StringUtils;
import com.school.app.dtos.LoginResponseDto;
import com.school.app.exceptions.UnexpectedErrorException;
import com.school.app.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    @Override
    public LoginResponseDto login(String fullName, String password) {
        if(StringUtils.isBlank(fullName) || StringUtils.isBlank(password)){
            throw new UnexpectedErrorException("Username or password is empty","username or password is empty");
        }
        var user = userRepo.findByFullName(fullName);


       if(user == null) {
           throw new InvalidLoginException("Invalid username or password", "Invalid username or password");
       }


        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setStatus(200);
        loginResponseDto.setMessage("login successful");
        loginResponseDto.setUser(user);
        return loginResponseDto;
    }
}

