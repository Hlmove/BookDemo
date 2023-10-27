package com.briup.dao.extend;

import com.briup.pojo.extend.CategoryExtend;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 */
@Repository
public interface CategoryExtendDao {
    List<CategoryExtend> selectAllCategories();
}