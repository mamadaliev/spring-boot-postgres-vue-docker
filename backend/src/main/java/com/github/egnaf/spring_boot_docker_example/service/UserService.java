package com.github.egnaf.spring_boot_docker_example.service;

import com.github.egnaf.spring_boot_docker_example.domain.User;
import com.github.egnaf.spring_boot_docker_example.exception.UserExistsException;
import com.github.egnaf.spring_boot_docker_example.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(long id) throws UserNotFoundException;
    User addUser(String nickname, String email, String password) throws UserExistsException;
}
