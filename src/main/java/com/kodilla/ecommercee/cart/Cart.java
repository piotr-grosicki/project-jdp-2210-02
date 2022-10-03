package com.kodilla.ecommercee.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long orderId;
}
