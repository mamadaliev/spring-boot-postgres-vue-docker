package com.company.app;

import com.company.app.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private final HumanService humanService;

    @Autowired
    public DemoApplication(HumanService humanService) {
        this.humanService = humanService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public void fillHumansTable() {
        humanService.create("maeshi", 19);
        humanService.create("hardelele", 20);
        humanService.create("varkrift", 20);
    }
}
