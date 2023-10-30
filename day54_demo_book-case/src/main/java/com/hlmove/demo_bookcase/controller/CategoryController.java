package com.hlmove.demo_bookcase.controller;


import com.hlmove.demo_bookcase.result.Result;
import com.hlmove.demo_bookcase.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hlmove
 */
@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    private Result getAll() {
        return Result.success(categoryService.getAllCategories());
    }
}
