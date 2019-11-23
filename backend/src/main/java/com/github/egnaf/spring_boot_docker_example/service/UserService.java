package com.github.egnaf.spring_boot_docker_example.service;

import com.github.egnaf.spring_boot_docker_example.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(long id);
    void addUser(String nickname, String email, String password);
}
