package com.hlmove.demo_bookcase.service.Impl;


import com.hlmove.demo_bookcase.dao.extend.CategoryExtendDao;
import com.hlmove.demo_bookcase.pojo.extend.CategoryExtend;
import com.hlmove.demo_bookcase.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hlmove
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryExtendDao categoryExtendDao;


    @Override
    public List<CategoryExtend> getAllCategories() {
        return categoryExtendDao.selectAllCategories();

//        return null;
    }
}