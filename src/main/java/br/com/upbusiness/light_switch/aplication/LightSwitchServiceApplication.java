package br.com.upbusiness.light_switch.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"br.com.upbusiness.light_switch.repository"})
@ComponentScan(basePackages = {"br.com.upbusiness.light_switch.controller", "br.com.upbusiness.light_switch.service"})
public class LightSwitchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightSwitchServiceApplication.class, args);
    }

}
