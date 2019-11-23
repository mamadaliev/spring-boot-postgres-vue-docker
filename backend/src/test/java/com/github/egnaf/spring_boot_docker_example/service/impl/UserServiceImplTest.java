package com.github.egnaf.spring_boot_docker_example.service.impl;

import com.github.egnaf.spring_boot_docker_example.ApplicationTest;
import com.github.egnaf.spring_boot_docker_example.domain.User;
import com.github.egnaf.spring_boot_docker_example.exception.UserExistsException;
import com.github.egnaf.spring_boot_docker_example.exception.UserNotFoundException;
import com.github.egnaf.spring_boot_docker_example.repository.UserRepository;
import com.github.egnaf.spring_boot_docker_example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
public class UserServiceImplTest extends ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        User user1 = new User(1L, "user1", "user1@mail.com", "pass");
        userRepository.save(user1);
        log.debug(user1.toString());

        User user2 = new User(2L, "user2", "user2@mail.com", "test");
        userRepository.save(user2);
        log.debug(user2.toString());
    }

    @Test
    public void getUsers() {
        //expected
        List<User> expected = new ArrayList<>();
        expected.add(new User(1L, "user1", "user1@mail.com", "pass"));
        expected.add(new User(2L, "user2", "user2@mail.com", "test"));

        //actual
        List<User> actual = userService.getUsers();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getUser() throws UserNotFoundException {
        //expected
        User expected = new User(1L, "user1", "user1@mail.com", "pass");

        //actual
        User actual = userService.getUser(1L);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void addUser() throws UserExistsException {
        //expected
        User expected = new User(3L, "user3", "user3@mail.com", "demo");

        //actual
        User actual = userService.addUser(expected.getNickname(), expected.getEmail(), expected.getPassword());
        userRepository.deleteById(3L);

        //assert
        assertEquals(expected, actual);
    }
}
