package com.kodilla.ecommercee.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private Long groupId;
}
