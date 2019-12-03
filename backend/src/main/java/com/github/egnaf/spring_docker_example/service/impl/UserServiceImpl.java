package com.github.egnaf.spring_docker_example.service.impl;

import com.github.egnaf.spring_docker_example.domain.User;
import com.github.egnaf.spring_docker_example.exception.UserExistsException;
import com.github.egnaf.spring_docker_example.exception.UserNotFoundException;
import com.github.egnaf.spring_docker_example.repository.UserRepository;
import com.github.egnaf.spring_docker_example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }
    }

    @Override
    public User addUser(String nickname, String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new UserExistsException("User email=" + email + " already exists");
        } else if (userRepository.existsByNickname(nickname)) {
            throw new UserExistsException("User nickname=" + nickname + " already exists");
        } else if (password == null || password.equals("")) {
            throw new IllegalArgumentException();
        } else {
            User user = new User();
            user.setNickname(nickname);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
            return user;
        }
    }
}
