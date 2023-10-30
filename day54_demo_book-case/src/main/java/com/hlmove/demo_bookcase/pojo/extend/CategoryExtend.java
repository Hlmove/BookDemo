package com.hlmove.demo_bookcase.pojo.extend;


import com.hlmove.demo_bookcase.pojo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Hlmove
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryExtend extends Category {
    // 二级菜单
    private List<Category> children;
    // 图书信息
    // private List<Book> books;
}
