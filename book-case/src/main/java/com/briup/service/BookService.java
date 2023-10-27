package com.briup.service;

import com.briup.pojo.Book;
import com.briup.pojo.extend.BookExtend;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Hlmove
 */
public interface BookService {

    List<BookExtend> getBooksByCondition(String keyword, Integer categoryId);


    void addBook(Book book);

    Book getBookById(Integer id);

    void modifyBook(Book book);

    void modifyBookStatus(Integer id, Integer status);

    void removeBookById(Integer id);

    void removeBatchByIds(List<Integer> ids);

    //    PageBean getBooksByConditionAndPage(String keyword, Integer categoryId, Integer pageNum, Integer pageSize);
    PageInfo<BookExtend> getBooksByConditionAndPage(String keyword, Integer categoryId, Integer pageNum, Integer pageSize);
    /*



     */
}
