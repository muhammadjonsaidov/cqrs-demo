package com.example.cqrsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 👈 asinxron eventlarni yoqish
@SpringBootApplication
public class CqrsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsDemoApplication.class, args);
    }

}
