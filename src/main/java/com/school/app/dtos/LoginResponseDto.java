package com.school.app.dtos;


import com.school.app.models.User;
import lombok.Data;

@Data
public class LoginResponseDto {
    Integer status;
    String message;
    User user;

}
