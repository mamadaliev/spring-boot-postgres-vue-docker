package com.company.app.service.impl;

import com.company.app.entity.Human;
import com.company.app.repository.HumanRepository;
import com.company.app.service.HumanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;

    public HumanServiceImpl(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @Override
    public List<Human> getAll() {
        return humanRepository.findAll();
    }

    @Override
    public Human getOneById(Integer id) {
        return humanRepository.getOne(id);
    }

    @Override
    public void create(String nickname, int age) {
        humanRepository.save(new Human(nickname, age));
    }
}
