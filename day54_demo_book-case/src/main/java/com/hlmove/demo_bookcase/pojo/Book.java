package com.hlmove.demo_bookcase.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hlmove
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private String publisher;
    private Double price;
    private Integer storeNum;
    private Integer status;
    private Integer categoryId;
}