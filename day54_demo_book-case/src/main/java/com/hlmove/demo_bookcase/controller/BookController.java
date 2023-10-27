package com.hlmove.demo_bookcase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/27 10:00
 * @Description com.hlmove.demo_bookcase.controller
 * @Note
 */
@RestController  //控制器，放入容器，返回json
@RequestMapping("/book")  //模块功能统一前缀
public class BookController {
    //注入service层
}
