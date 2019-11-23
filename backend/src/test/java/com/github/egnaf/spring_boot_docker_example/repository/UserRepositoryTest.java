package com.github.egnaf.spring_boot_docker_example.repository;

import com.github.egnaf.spring_boot_docker_example.ApplicationTest;
import com.github.egnaf.spring_boot_docker_example.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
public class UserRepositoryTest extends ApplicationTest {

    @Autowired
    private UserRepository userRepository;

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
    public void existsByEmailIsTrue() {
        //actual
        boolean actual = userRepository.existsByEmail("user1@mail.com");

        //assert
        assertTrue(actual);
    }

    @Test
    public void existsByEmailIsFalse() {
        //actual
        boolean actual = userRepository.existsByEmail("user77@mail.com");

        //assert
        assertFalse(actual);
    }

    @Test
    public void existsByNicknameIsTrue() {
        //actual
        boolean actual = userRepository.existsByNickname("user1");

        //assert
        assertTrue(actual);
    }

    @Test
    public void existsByNicknameIsFalse() {
        //actual
        boolean actual = userRepository.existsByNickname("user77");

        //assert
        assertFalse(actual);
    }
}
