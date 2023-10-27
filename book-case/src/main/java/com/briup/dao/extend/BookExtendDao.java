package com.briup.dao.extend;

import com.briup.pojo.extend.BookExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hlmove
 */
@Repository
public interface BookExtendDao {
    List<BookExtend> selectBooksByCondition(@Param("keyword") String keyword,
                                            @Param("categoryId") Integer categoryId);

    // 条件分页查询图书数据
    List<BookExtend> selectBooksByConditionAndPage(
            @Param("keyword") String keyword,
            @Param("categoryId") Integer categoryId,
            @Param("pageIndex") Integer pageIndex,
            @Param("pageSize") Integer pageSize);

    // 条件查询图书数量
    Long selectCount(@Param("keyword") String keyword,
                     @Param("categoryId") Integer categoryId);
}
