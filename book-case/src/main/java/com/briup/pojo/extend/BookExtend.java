package com.briup.pojo.extend;

import com.briup.pojo.Book;
import com.briup.pojo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Hlmove
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookExtend extends Book {
    // 图书所属分类
    private Category category;
}
