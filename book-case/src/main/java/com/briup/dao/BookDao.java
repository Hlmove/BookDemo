package com.briup.dao;

import com.briup.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 */
@Repository
public interface BookDao {

    void insertBook(Book book);

    Book selectBookById(@Param("id") Integer id);

    void updateBook(Book book);

    void updateBookStatus(@Param("id") Integer id,
                          @Param("status") Integer status);
    void deleteBookById(@Param("id") Integer id);
    void deleteBookByIds(@Param("ids") List<Integer> ids);
    /*



*/
}

