package com.poor.billy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PoorBilly {
    public static void main(String[] args) {
        SpringApplication.run(PoorBilly.class, args);
    }
}