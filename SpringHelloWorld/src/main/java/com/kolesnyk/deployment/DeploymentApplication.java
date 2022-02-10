package com.kolesnyk.deployment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Order(2)
public class DeploymentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("begin main");
        SpringApplication.run(DeploymentApplication.class, args);
        System.out.println("end main");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");
    }
}


@Component
@Order(1)
class First implements CommandLineRunner {
    @Override
    public void run(String[] args) throws Exception {
        System.out.println("first");
    }
}


@Component
@Order(3)
class Second implements CommandLineRunner {
    @Override
    public void run(String[] args) throws Exception {
        System.out.println("second");
    }
}

