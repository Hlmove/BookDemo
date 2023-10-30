package com.hlmove.demo_bookcase.service;

import com.hlmove.demo_bookcase.pojo.extend.BookExtend;

import java.util.List;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/27 10:05
 * @Description com.hlmove.demo_bookcase.service
 * @Note
 */
public interface IBookService {
    List<BookExtend> findAll(String keyword, Integer categoryId);
}
