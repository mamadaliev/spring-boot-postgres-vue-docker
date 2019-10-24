package com.github.egnaf.app.service;

import com.github.egnaf.app.entity.HumanEntity;

import java.util.List;

public interface HumanService {

    List<HumanEntity> getAll();
    HumanEntity getOneById(Integer id);
    void create(String nickname, int age);
}
