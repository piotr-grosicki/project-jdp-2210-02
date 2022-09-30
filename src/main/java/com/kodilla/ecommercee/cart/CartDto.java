package com.kodilla.ecommercee.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CartDto {
    private Long id;
    private Long userId;
    private Long orderId;
}
