package com.example.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAdminServer
@EnableDiscoveryClient
@EnableScheduling
public class Application {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class,args);
    }

    @Configuration(proxyBeanMethods = false)
    public static class SecurityPermitAllConfig {

        @Bean
        protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests.anyRequest().permitAll())
                .csrf((csrf) -> csrf.disable())
                .build();
        }
    }
}
