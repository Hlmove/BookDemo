package com.briup.controller;

import com.briup.pojo.Book;
import com.briup.pojo.extend.BookExtend;
import com.briup.result.Result;
import com.briup.service.BookService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hlmove
 */
@Api(tags = "图书管理相关接口")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    private final BookService bookService;


//    //条件查询所有书籍
//    @ApiOperation(value = "条件查询图书信息", notes = "采用自定义PageBean实现")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "keyword", value = "搜索关键字（书名/作者/出版社）", paramType = " query"),
//            @ApiImplicitParam(name = "categoryId", value = "搜索图书所属分类编号", paramType = " query")
//    })
//    @GetMapping
//    public Result getByCondition(String keyword, Integer categoryId) {
//        System.out.println("in bookController, getByCondition()...");
//        List<BookExtend> list =
//                bookService.getBooksByCondition(keyword, categoryId);
//        return Result.success(list);
//    }


//
//    //手动实现分页查询
//    @ApiOperation(value = "条件分页查询图书信息", notes = "采用自定义PageBean实现")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "keyword", value = "搜索关键字（书名/作者/出版社）", paramType = "query"),
//            @ApiImplicitParam(name = "categoryId", value = "搜索图书所属分类编号", paramType = "query"),
//            @ApiImplicitParam(name = "pageNum", value = "搜索页码", required = true, paramType = "query"),
//            @ApiImplicitParam(name = "pageSize", value = "每页数据条数", required = true, paramType = "query")
//    })
//    @GetMapping("/page")
//    private Result getByPageAndCondition(String keyword, Integer categoryId, Integer pageNum, Integer pageSize) {
//        PageBean pageBean =
//                bookService.getBooksByConditionAndPage(keyword, categoryId, pageNum, pageSize);
//        return Result.success(pageBean);
//    }

    //插件实现分页查询
    @ApiOperation(value = "条件分页查询图书信息", notes = "采用pageHelper实现")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "搜索关键字（书名/作者/出版社）", paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "搜索图书所属分类编号", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "搜索页码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据条数", required = true, paramType = "query")
    })
    @GetMapping("/page")
    private Result getByPageAndCondition(String keyword, Integer categoryId,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<BookExtend> pageInfo =
                bookService.getBooksByConditionAndPage(keyword, categoryId, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    //新增图书
    //接收前端页面传递的json对象，需要使用@RequestBody注解
    @ApiOperation(value = "添加图书信息", notes = "图书名称、作者、出版社不能为空")
    @PostMapping
    public Result add(@RequestBody Book book) {
        bookService.addBook(book);
        return Result.success("添加书籍成功");
    }

    //回显数据在修改上
    @ApiOperation(value = "根据id查询图书信息", notes = "id不能为 null")
    @ApiImplicitParam(name = "id", value = "图书编号", required = true, paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(bookService.getBookById(id));
    }

    @ApiOperation(value = "修改图书信息", notes = "图书编号、名称、作者、出版社不能为空")
    @PutMapping
    public Result modifyBook(@RequestBody Book book) {
        bookService.modifyBook(book);
        return Result.success();
    }

    @ApiOperation(value = "修改图书状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书编号", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "修改的状 态", paramType = "query")
    })
    @PutMapping("/{id}/{status}")
    public Result modifyStatus(@PathVariable Integer id,
                               @PathVariable Integer status) {
        bookService.modifyBookStatus(id, status);
        return Result.success();
    }

    @ApiOperation(value = "删除图书信息")
    @ApiImplicitParam(name = "id", value = "要删除的图书的编号",
            paramType = "path")
    @DeleteMapping("/{id}")
    private Result remove(@PathVariable Integer id) {
        bookService.removeBookById(id);
        return Result.success();
    }

    @ApiOperation(value = "批量删除图书信息")
    @ApiImplicitParam(name = "ids", value = "要删除的图书的编号的集 合")
    @DeleteMapping
    private Result removeBatchByIds(@RequestBody List<Integer> ids) {
        bookService.removeBatchByIds(ids);
        return Result.success();
    }
}
