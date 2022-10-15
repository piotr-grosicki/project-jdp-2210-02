package com.kodilla.ecommercee.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {
    private Long cartId;
    private Long userId;
    private Long orderId;
    private List<Long> productsId;
}
