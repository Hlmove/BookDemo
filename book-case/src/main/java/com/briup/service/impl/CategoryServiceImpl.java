package com.briup.service.impl;

import com.briup.dao.extend.CategoryExtendDao;
import com.briup.pojo.extend.CategoryExtend;
import com.briup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hlmove
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryExtendDao categoryExtendDao;

    @Override
    public List<CategoryExtend> getAllCategories() {
        return categoryExtendDao.selectAllCategories();

//        return null;
    }
}