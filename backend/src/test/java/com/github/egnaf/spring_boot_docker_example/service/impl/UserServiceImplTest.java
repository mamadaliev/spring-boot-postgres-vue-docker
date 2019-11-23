package com.github.egnaf.spring_boot_docker_example.service.impl;

import com.github.egnaf.spring_boot_docker_example.domain.User;
import com.github.egnaf.spring_boot_docker_example.exception.UserNotFoundException;
import com.github.egnaf.spring_boot_docker_example.repository.UserRepository;
import com.github.egnaf.spring_boot_docker_example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

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
    public void getUserTest() throws UserNotFoundException {
        User actual = userService.getUser(1L);
        User expected = new User(1L, "user1", "user1@mail.com", "pass");
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }
}
