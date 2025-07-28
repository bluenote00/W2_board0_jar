package com.example.W2_board0_jar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.example.W2_board0_jar.dao")
public class W2Board0JarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(W2Board0JarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(W2Board0JarApplication.class, args);
    }
}

