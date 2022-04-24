package com.example.Simple_Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication

public class SimpleTaskApplication {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(SimpleTaskApplication.class, args);
    }

}
