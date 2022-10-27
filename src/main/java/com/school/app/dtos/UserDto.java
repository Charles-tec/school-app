package com.school.app.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;



}
