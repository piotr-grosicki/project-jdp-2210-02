package com.kodilla.ecommercee.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @PostMapping("/empty")
    ResponseEntity<?> createEmptyCart(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product")
    ResponseEntity<?> addProductToCart(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}")
    ResponseEntity<?> createOrderFromCart(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<?> getProductsFromCart(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteProductFromCartById(){
        return ResponseEntity.ok().build();
    }

}
