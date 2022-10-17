package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.order.OrderDto;
import com.kodilla.ecommercee.order.OrderService;
import com.kodilla.ecommercee.product.ProductNotFoundException;
import com.kodilla.ecommercee.user.NoFoundUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;
    private final OrderService orderService;

    CartController(final CartService cartService, final OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping
    ResponseEntity<List<CartDto>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }
    @PostMapping
    ResponseEntity<Void> createOrderFromCart(@RequestBody OrderDto orderDto) throws NoFoundCartException, NoFoundUserException {
        orderService.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/empty/{userId}")
    ResponseEntity<CartDto> createEmptyCart(@PathVariable Long userId) throws NoFoundUserException {
        if (cartService.createEmptyCart(userId))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/product/{cartId}/{productId}")
    ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws NoFoundCartException, ProductNotFoundException {
        if (cartService.addProductToCart(cartId,productId))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "{cartId}/{productId}")
    ResponseEntity<Void> deleteProductFromCartById(@PathVariable Long cartId, @PathVariable Long productId) throws NoFoundCartException, ProductNotFoundException {
        if (cartService.deleteProductFromCartById(cartId,productId))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}