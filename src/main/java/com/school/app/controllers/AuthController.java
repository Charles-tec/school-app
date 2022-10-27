package com.school.app.controllers;


import com.school.app.dtos.LoginResponseDto;
import com.school.app.dtos.LoginTo;
import com.school.app.dtos.UserDto;
import com.school.app.services.AuthService;
import com.school.app.services.UserService;
import com.school.app.util.Response;
import com.school.app.util.ResponseBuild;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Repository
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final ResponseBuild<UserDto> userResponseBuild;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@RequestBody LoginTo loginTo) {
        return ResponseEntity.ok(authService.login(loginTo.getFullName(), loginTo.getPassword()));
    }
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userResponseBuild.responseFunction
                .apply(userService.save(userDto)), HttpStatus.OK);

    }


}
