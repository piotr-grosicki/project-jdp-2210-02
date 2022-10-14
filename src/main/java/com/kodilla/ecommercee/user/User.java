package com.kodilla.ecommercee.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IS_BLOCK")
    private boolean blockStatus;

    User(final String login, final String password, final String name, final String surname, final String address, final String city, final String phoneNumber, final String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.blockStatus = false;
    }
}
