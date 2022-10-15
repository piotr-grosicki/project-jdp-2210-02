package com.kodilla.ecommercee.cart;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public Cart mapToCart(CartDto cartDto){
        return new Cart();
    }

    public CartDto mapToCartDto(Cart cart){
        return new CartDto();
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream().map(this::mapToCartDto).collect(Collectors.toList());
    }
}