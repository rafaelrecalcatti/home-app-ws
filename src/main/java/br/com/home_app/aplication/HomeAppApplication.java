package br.com.home_app.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"br.com.home_app.repository"})
@ComponentScan(basePackages = {"br.com.home_app.controller", "br.com.home_app.service"})
public class HomeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeAppApplication.class, args);
    }

}
