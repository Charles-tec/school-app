package com.school.app.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="fullname")
    private String fullName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="confirmpassword")
    private String confirmPassword;

}
