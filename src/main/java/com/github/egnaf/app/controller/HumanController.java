package com.github.egnaf.app.controller;

import com.github.egnaf.app.entity.HumanEntity;
import com.github.egnaf.app.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "humanController")
public class HumanController {

    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping(value = "/humans")
    public List<HumanEntity> getAll() {
        return humanService.getAll();
    }
}
