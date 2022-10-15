package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.order.Order;
import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CART_ID", unique = true)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ProductsInCart",
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"),
            joinColumns = @JoinColumn(name = "CART_ID")
    )
    private List<Product> products;
}
