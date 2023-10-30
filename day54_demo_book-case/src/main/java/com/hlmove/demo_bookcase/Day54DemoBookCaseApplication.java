package com.hlmove.demo_bookcase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hlmove
 */
@MapperScan("com.hlmove.demo_bookcase.dao")
@SpringBootApplication
public class Day54DemoBookCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day54DemoBookCaseApplication.class, args);
    }

}
