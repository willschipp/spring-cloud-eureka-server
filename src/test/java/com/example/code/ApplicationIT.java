package com.example.code;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = {"eureka.client.registerWithEureka=false"})
public class ApplicationIT {

    @Autowired
    ApplicationContext context;

    @Test
    public void testSuccessfulStartup() throws Exception {
        assertTrue(context.getBeanDefinitionCount() > 0);
    }
}
