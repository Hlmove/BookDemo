package com.hlmove.demo_bookcase;

import com.hlmove.demo_bookcase.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day54DemoBookCaseApplicationTests {
@Autowired
private IBookService bookService;
    @Test
    void contextLoads() {
        bookService.findAll("ja",1);
    }

}
