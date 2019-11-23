package com.github.egnaf.spring_boot_docker_example.rest;

import com.github.egnaf.spring_boot_docker_example.domain.User;
import com.github.egnaf.spring_boot_docker_example.exception.UserExistsException;
import com.github.egnaf.spring_boot_docker_example.exception.UserNotFoundException;
import com.github.egnaf.spring_boot_docker_example.service.UserService;
import com.github.egnaf.spring_boot_docker_example.transfer.UserDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> getUsers() {
        List<UserDto> users = userService.getUsers().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        try {
            UserDto user = mapper.map(userService.getUser(id), UserDto.class);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            UserDto userDto = mapper.map(
                    userService.addUser(user.getNickname(), user.getEmail(), user.getPassword()), UserDto.class);
            return ResponseEntity.ok(userDto);
        } catch (UserExistsException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
