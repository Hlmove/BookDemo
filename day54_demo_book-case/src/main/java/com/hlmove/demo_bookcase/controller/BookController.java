package com.hlmove.demo_bookcase.controller;

import com.hlmove.demo_bookcase.pojo.extend.BookExtend;
import com.hlmove.demo_bookcase.result.Result;
import com.hlmove.demo_bookcase.service.IBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/27 10:00
 * @Description com.hlmove.demo_bookcase.controller
 * @Note
 */
@RestController  //控制器，放入容器，返回json
@RequestMapping("/books")  //模块功能统一前缀
@RequiredArgsConstructor
@Log4j
public class BookController {
    //注入service层
    private final IBookService bookService;


    /**
     * 查询所有数据
     *
     * @return 结果成功 统一响应
     * @author Hlmove
     */
    @GetMapping
    public Result findAll(String keyword, Integer categoryId) {
        List<BookExtend> books = bookService.findAll(keyword, categoryId);
        log.info("书籍信息 " + books);
        return Result.success(books);
    }


//    @GetMapping
//    public Result findAllConditionCategory() {
//        List<Book> books = bookService.findAll();
//        log.info("书籍信息 "+books);
//        return Result.success(books);
//    }
}
