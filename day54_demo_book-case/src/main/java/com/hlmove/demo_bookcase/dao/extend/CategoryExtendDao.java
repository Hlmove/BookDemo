package com.hlmove.demo_bookcase.dao.extend;


import com.hlmove.demo_bookcase.pojo.extend.CategoryExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 */
@Repository
public interface CategoryExtendDao {
    List<CategoryExtend> selectAllCategories();
}