package com.sytoss.edu2021.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        classes = ConfigServer.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ConfigServerTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldCreateApplicationContext() {
        assertNotNull(context);
    }
}