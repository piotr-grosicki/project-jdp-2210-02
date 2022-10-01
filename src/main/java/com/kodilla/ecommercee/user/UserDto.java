package com.kodilla.ecommercee.user;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
    private boolean isBlock;

    UserDto(final String login, final String password, final String name, final String surname, final String address, final String city, final String phoneNumber, final String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}