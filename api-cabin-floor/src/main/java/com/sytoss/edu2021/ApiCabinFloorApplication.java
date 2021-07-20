package com.sytoss.edu2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class ApiCabinFloorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiCabinFloorApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Scheduled(fixedDelay = 10000)
    public void printDelay() {
        System.out.println("Прошло 10 секунд!");
    }
}
