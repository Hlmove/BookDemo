package com.briup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hlmove
 */
//开启swagger-ui功能
//@EnableSwagger2Doc
@MapperScan("com.briup.dao")
@SpringBootApplication
public class BookCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCaseApplication.class, args);
    }

}
