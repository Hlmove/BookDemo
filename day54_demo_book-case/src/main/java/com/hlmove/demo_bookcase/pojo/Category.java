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
public class Category{
    private Integer id;
    private String name;
    private String description;
    private Integer parentId;
}