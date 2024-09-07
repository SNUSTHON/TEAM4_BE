package com.example.team4_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Team4BeApplication {
    public static void main(String[] args) {
        SpringApplication.run(Team4BeApplication.class, args);
    }
}
