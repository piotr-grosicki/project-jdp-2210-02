package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public CartDto mapToCartDto(Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getUser().getId(),
                cart.getOrder().getId(),
                cart.getProducts().stream().map(Product::getId).collect(Collectors.toList())
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}