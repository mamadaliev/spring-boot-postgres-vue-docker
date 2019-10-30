package com.company.app.service;

import com.company.app.entity.Human;

import java.util.List;

public interface HumanService {

    List<Human> getAll();
    Human getOneById(Integer id);
    void create(String nickname, int age);
}
