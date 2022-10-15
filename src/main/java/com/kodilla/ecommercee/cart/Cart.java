package com.kodilla.ecommercee.cart;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CART_ID", unique = true)
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "ORDER_ID")
    private Long orderId;
}
