package com.briup.service.impl;

import com.briup.dao.BookDao;
import com.briup.dao.CategoryDao;
import com.briup.dao.extend.BookExtendDao;
import com.briup.exception.ServiceException;
import com.briup.pojo.Book;
import com.briup.pojo.Category;
import com.briup.pojo.extend.BookExtend;
import com.briup.result.ResultCode;
import com.briup.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Hlmove
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookExtendDao bookExtendDao;

    @Autowired
    private BookDao bookDao;
    //需要判断2级类别是否存在，所以特别引入
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<BookExtend> getBooksByCondition(String keyword, Integer categoryId) {
        return bookExtendDao.selectBooksByCondition(keyword, categoryId);
    }

    @Override
    public void addBook(Book book) {
        // 参数是否为空校验
        validate(book);
        // 判断分类信息是否存在
        Integer categoryId = book.getCategoryId();
        if (categoryId != null) {
            categoryIsOrNotExist(categoryId);
        }
        // 执行添加操作
        bookDao.insertBook(book);
    }

    @Override
    public Book getBookById(Integer id) {
        // 判断图书信息是否存在
        Book book = bookDao.selectBookById(id);
        if (book == null) {
            throw new
                    ServiceException(ResultCode.BOOK_IS_NOT_EXIST);
        }
        return book;
    }

    //更新书籍信息
    @Override
    public void modifyBook(Book book) {
        // 1.参数校验
        this.validate(book);
        // 2.判断图书信息是否存在
        bookIsOrNotExist(book.getId());
        // 3.判断分类信息是否存在
        if (book.getCategoryId() != null) {
            categoryIsOrNotExist(book.getCategoryId());
        }
        // 4.执行修改
        bookDao.updateBook(book);
    }

    @Override
    public void modifyBookStatus(Integer id, Integer status) {
        // 判断图书信息是否存在
        bookIsOrNotExist(id);
        // 修改图书状态
        bookDao.updateBookStatus(id, status);
    }

    @Override
    public void removeBookById(Integer id) {
        // 判断图书信息是否存在
        bookIsOrNotExist(id);
        // 修改图书状态
        bookDao.deleteBookById(id);
    }

    @Override
    public void removeBatchByIds(List<Integer> ids) {
        //判断批量删除的图书信息是否存在
        ids.forEach(this::bookIsOrNotExist);
        //删除
        bookDao.deleteBookByIds(ids);

    }

    @Override
    public PageInfo<BookExtend> getBooksByConditionAndPage(String keyword, Integer categoryId, Integer pageNum, Integer pageSize) {
        //1.开启分页查询，注意要传入 查询的页码 还有 每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        //2.常规条件查询
        List<BookExtend> bookExtends =
                bookExtendDao.selectBooksByCondition(keyword, categoryId);
        //3.封装得到PageInfo对象
        PageInfo<BookExtend> pageInfo = new PageInfo<>(bookExtends);
        //4.返回 分页信息对象
        return pageInfo;
    }


//    @Override
//    public PageBean getBooksByConditionAndPage(String keyword, Integer categoryId, Integer pageNum, Integer pageSize) {
//        // 计算开始索引pageIndex
//        Integer pageIndex = (pageNum - 1) * pageSize;
//        // 查询当前页的图书数据
//        List<BookExtend> books =
//                bookExtendDao.selectBooksByConditionAndPage(keyword, categoryId, pageIndex, pageSize);
//        // 查询图书总条数
//        Long total = bookExtendDao.selectCount(keyword, categoryId);
//        // 封装PageBean对象，返回
//        return new PageBean(total, books);
//    }

    // 判断图书信息是否存在
    private void bookIsOrNotExist(Integer id) {
        Book book = bookDao.selectBookById(id);
        if (book == null) {
            throw new
                    ServiceException(ResultCode.BOOK_IS_NOT_EXIST);
        }
    }

    // 参数为空校验方法
    private void validate(Book book) {
        if (!StringUtils.hasText(book.getName())) {
            throw new
                    ServiceException(ResultCode.BOOK_NAME_IS_NULL);
        }
        if (!StringUtils.hasText(book.getAuthor())) {
            throw new
                    ServiceException(ResultCode.BOOK_AUTHOR_IS_NULL);
        }
        if (!StringUtils.hasText(book.getPublisher())) {
            throw new
                    ServiceException(ResultCode.BOOK_PUBLISHER_IS_NULL);
        }
    }

    // 判断分类信息是否存在
    private void categoryIsOrNotExist(Integer id) {
        Category category = categoryDao.selectCategoryById(id);
        if (category == null) {
            throw new
                    ServiceException(ResultCode.CATEGORY_IS_NOT_EXIST);
        }
    }
}


