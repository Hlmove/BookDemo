package com.briup.controller;

import com.briup.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hlmove
 * @date 创建日期 2023/10/26 17:26
 * @Description com.briup.controller
 * @Note
 */
@Api(tags = "Swagger测试")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @ApiOperation(notes = "swagger测试", value = "test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",
                    value = "用户名", required = true, paramType = " query", dataType = " String")
    })
    @GetMapping("/hello")
    public String hello(String userName) {
        System.out.println("in hello ... ");
        return "欢迎 " + userName + " 进入首页";
    }

    @ApiOperation(value = "根据id删除用户", notes = "id必须存在且有 效")
    @ApiImplicitParam(name = "id",
            value = "用户id", required = true, paramType = "path", dataType = "long")
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        System.out.println("in deleteById,id: " + id);
        return Result.success("删除成功");
    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户 名", required = true, paramType = " form", dataType = " String"),
            @ApiImplicitParam(name = "password", value = "密 码", required = true, paramType = " form")
    })
    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public String login(String userName,
                        @RequestParam("password") String
                                password) {
        System.out.println("username: " + userName);
        System.out.println("password: " + password);
        return "欢迎你，" + userName;
    }
}
