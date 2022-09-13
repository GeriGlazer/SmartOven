package com.fp.smartOven.service;

import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.repositories.UserRepo;
import com.fp.smartOven.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisOperations;
import static org.assertj.core.api.Assertions.*;


@DataRedisTest
public class ServiceTests {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;
    @Autowired
    RedisOperations<Object, Object> operations;

    User user = new User("", "GeriG", "geri@gmail.com", "2022");

    @BeforeEach
    @AfterEach
    void setUp(){
        operations.execute((RedisConnection connection) -> {
            connection.flushDb();
            return "OK";
        });
    }

    @Test
    void createNewUser() {
        userRepo.save(user);

        System.out.println("new user: " + user.getName());
    }

    @Test
    void login() {
        createNewUser();
        try {
            userService.login(user);
        } catch (CustomExceptions e) {
            System.out.println(e.getMessage());;
        }
    }

    @Test
    void updateDetails(User user){
        login();
        user.setEmail("gerig@gmail.com");
        userRepo.save(user);
    }
}
