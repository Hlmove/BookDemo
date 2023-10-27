package com.briup.bean;

import com.briup.pojo.extend.BookExtend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/26 19:08
 * @Description com.briup.bean
 * @Note
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    // 数据总条数
    private Long total;
    // 查询页数据
    private List<BookExtend> list;
}
