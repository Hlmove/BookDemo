package com.hlmove.demo_bookcase.service.Impl;

import com.hlmove.demo_bookcase.dao.extend.BookExtendDao;
import com.hlmove.demo_bookcase.pojo.extend.BookExtend;
import com.hlmove.demo_bookcase.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/27 10:06
 * @Description com.hlmove.demo_bookcase.service.Impl
 * @Note
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    private final BookExtendDao bookExtendDao;


    @Override
    public List<BookExtend> findAll(String keyword, Integer categoryId) {
        return bookExtendDao.findAll(keyword,categoryId);
    }
}
