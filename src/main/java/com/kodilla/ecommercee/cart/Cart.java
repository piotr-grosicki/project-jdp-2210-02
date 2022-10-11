package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.order.Order;
import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue

    @Column(name = "CART_ID", unique = true)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ProductsInCart",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
    )
    private List<Product> products;
}
