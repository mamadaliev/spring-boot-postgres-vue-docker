package com.github.egnaf.spring_boot_docker_example.rest;

import com.github.egnaf.spring_boot_docker_example.domain.User;
import com.github.egnaf.spring_boot_docker_example.service.UserService;
import com.github.egnaf.spring_boot_docker_example.transfer.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;
    private final Mapper mapper;

    @Autowired
    public UserController(UserService userService, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.getUsers().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        log.debug(users.toString());
        return users;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable long id) {
        UserDto user = mapper.map(userService.getUser(id), UserDto.class);
        log.debug(user.toString());
        return user;
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody User user) {
        UserDto newUser =  mapper.map(
                userService.addUser(user.getNickname(), user.getEmail(), user.getPassword()), UserDto.class);
        log.debug(newUser.toString());
        return newUser;
    }
}
