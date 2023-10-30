package com.briup.service.impl;

import com.briup.dao.extend.CategoryExtendDao;
import com.briup.pojo.extend.CategoryExtend;
import com.briup.service.CategoryService;
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