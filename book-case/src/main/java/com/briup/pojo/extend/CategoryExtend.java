package com.briup.pojo.extend;

import com.briup.pojo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryExtend extends Category{
    // 二级菜单
    private List<Category> children;
    // 图书信息
    // private List<Book> books;
}
