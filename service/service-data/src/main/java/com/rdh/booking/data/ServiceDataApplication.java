package com.rdh.booking.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rdh")
public class ServiceDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDataApplication.class, args);
    }
}
