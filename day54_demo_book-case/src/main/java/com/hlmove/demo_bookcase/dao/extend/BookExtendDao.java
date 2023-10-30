package com.hlmove.demo_bookcase.dao.extend;


import com.hlmove.demo_bookcase.pojo.extend.BookExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 */
@Repository
public interface BookExtendDao {
    List<BookExtend> findAll(String keyword, Integer categoryId);
}
