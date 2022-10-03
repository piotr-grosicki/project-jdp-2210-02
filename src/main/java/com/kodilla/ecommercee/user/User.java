package com.kodilla.ecommercee.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
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
}
