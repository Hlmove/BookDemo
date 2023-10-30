package com.hlmove.demo_bookcase.dao;

import com.hlmove.demo_bookcase.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/27 10:11
 * @Description com.hlmove.demo_bookcase.dao
 * @Note
 */
@Repository
public interface BookDao {
    List<Book> findAll();
}
