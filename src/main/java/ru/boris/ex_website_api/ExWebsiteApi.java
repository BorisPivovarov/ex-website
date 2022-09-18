package ru.boris.ex_website_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Configuration
@SpringBootApplication
public class ExWebsiteApi {

    public static void main(String[] args) {
        SpringApplication.run(ExWebsiteApi.class, args);
    }

}
