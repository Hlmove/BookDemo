package com.hlmove.demo_bookcase.dao;


import com.hlmove.demo_bookcase.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Hlmove
 */
@Repository
public interface CategoryDao {
    Category selectCategoryById(@Param("id") Integer id);
}
