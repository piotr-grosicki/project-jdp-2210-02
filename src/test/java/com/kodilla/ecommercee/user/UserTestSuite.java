package com.kodilla.ecommercee.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUser(){
        // given
        User user = new User(
                "login",
                "password",
                "test name 123",
                "surname",
                "address",
                "city",
                "123-123-123",
                "mail@mail"
        );
        // when
        userRepository.save(user);
        String name = userRepository.findById(user.getId()).get().getName();
        // then
        assertEquals(1,userRepository.count());
        assertEquals("test name 123", name);
    }

    @Test
    public void createSeveralUsers(){
        // given
        User user = new User("login", "password", "test name 123", "surname", "address", "city", "123-123-123", "mail@mail");
        User user1 = new User("login1", "password1", "test name 345", "surname", "address", "city", "123-123-123", "mail@mail");
        User user2 = new User("login2", "password2", "test name 678", "surname", "address", "city", "123-123-123", "mail@mail");
        //when
        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

        String passwordUser2 = userRepository.findById(user2.getId()).get().getPassword();
        // then
        assertEquals("password2", passwordUser2);
        assertEquals(3,userRepository.count());

        // cleanUp
        userRepository.deleteAll();
    }

    @Test
    public void findUserById(){
        // given
        User user = new User(
                "login",
                "password",
                "test name 123",
                "surname",
                "address",
                "city",
                "123-123-123",
                "mail@mail"
        );
        // when
        userRepository.save(user);
        Long id = user.getId();
        // then
        assertTrue(userRepository.existsById(id));

        // cleanUp
        userRepository.deleteAll();
    }
}
