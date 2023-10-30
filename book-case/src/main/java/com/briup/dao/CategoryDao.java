package com.briup.dao;

import com.briup.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Hlmove
 */
@Repository
public interface CategoryDao {
    Category selectCategoryById(@Param("id") Integer id);
}
