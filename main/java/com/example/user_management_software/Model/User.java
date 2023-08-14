package com.example.user_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should not be empty")
    @Column(columnDefinition = "varchar(15) unique not null")
    private String name;
    @NotEmpty(message = "username should not be empty")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String username;
    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @Email
    @NotEmpty(message = "email should not be empty")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String email;
    @NotEmpty(message = "username should not be empty")
    @Column(columnDefinition = "varchar(5) not null check(role='admin' or role='user')")
    private String role;

    @NotNull(message = "username should not be empty")
    @Column(columnDefinition = "int not null ")
    private Integer age;
}
