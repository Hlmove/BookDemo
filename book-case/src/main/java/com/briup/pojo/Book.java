package com.briup.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hlmove
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("书籍参数")  //json的swagger注解，
public class Book {
    @ApiModelProperty(name = "id",value = "编号")
    private Integer id;
    @ApiModelProperty(name = "name",value = "书名")
    private String name;
    @ApiModelProperty(name = "description",value = "描述")
    private String description;
    @ApiModelProperty(name = "author",value = "作者")
    private String author;
    @ApiModelProperty(name = "publisher",value = "出版社")
    private String publisher;
    @ApiModelProperty(name = "price",value = "价格")
    private Double price;
    @ApiModelProperty(name = "storeNum",value = "书籍数量")
    private Integer storeNum;
    @ApiModelProperty(name = "status",value = "是否上架")
    private Integer status;
    @ApiModelProperty(name = "categoryId",value = "书籍分类")
    private Integer categoryId;
}
