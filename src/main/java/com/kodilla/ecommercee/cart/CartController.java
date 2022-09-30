package com.kodilla.ecommercee.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @PostMapping("/empty")
    ResponseEntity<CartDto> createEmptyCart(){
        return ResponseEntity.ok(new CartDto(null,null,null));
    }

    @PutMapping("/product/{cartId}")
    ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId){
        if (cartId == 3)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{id}")
    ResponseEntity<?> createOrderFromCart(@PathVariable Long id){
        if (id == 444)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    ResponseEntity<List<CartDto>> getProductsFromCart(@PathVariable Long id){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteProductFromCartById(@PathVariable Long id){
        if (id != 2)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}
