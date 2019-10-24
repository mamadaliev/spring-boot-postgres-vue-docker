package com.github.egnaf.app.service.impl;

import com.github.egnaf.app.entity.HumanEntity;
import com.github.egnaf.app.repository.HumanRepository;
import com.github.egnaf.app.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;

    @Autowired
    public HumanServiceImpl(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @Override
    public List<HumanEntity> getAll() {
        return humanRepository.findAll();
    }

    @Override
    public HumanEntity getOneById(Integer id) {
        return humanRepository.getOne(id);
    }

    @Override
    public void create(String nickname, int age) {
        humanRepository.save(new HumanEntity(nickname, age));
    }
}
