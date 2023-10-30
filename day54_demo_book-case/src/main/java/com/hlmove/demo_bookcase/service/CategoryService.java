package com.hlmove.demo_bookcase.service;


import com.hlmove.demo_bookcase.pojo.extend.CategoryExtend;

import java.util.List;

/**
 * @author Hlmove
 */
public interface CategoryService {

    List<CategoryExtend> getAllCategories();
}
