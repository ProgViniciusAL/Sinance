package com.vinicius.sinance;

import org.springframework.boot.SpringApplication;

public class TestSinanceApplication {

    public static void main(String[] args) {
        SpringApplication.from(SinanceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
