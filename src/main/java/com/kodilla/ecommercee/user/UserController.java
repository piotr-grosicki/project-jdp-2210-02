package com.kodilla.ecommercee.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/create")
    ResponseEntity<UserDto> createUser(){
        return ResponseEntity.ok(new UserDto(
                "login",
                "pass",
                "name",
                "surname",
                "addres",
                "city",
                "123-123-123",
                "mail@mail"
        ));
    }

    @Transactional
    @PatchMapping("/block/{id}")
    ResponseEntity<UserDto> toggleUserBlock(@PathVariable Long id){
        if (id == 3)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/login")
    ResponseEntity<Void> generateToken(Long userId, String login, String password){
        if (login.equals("test") && password.equals("test"))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}