package com.kodilla.ecommercee.order;

import com.kodilla.ecommercee.cart.Cart;
import com.kodilla.ecommercee.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    public Order(LocalDateTime dateOfOrder, LocalDateTime shippingDate, String shippingAddress, String shippingStatus) {
        this.dateOfOrder = dateOfOrder;
        this.shippingDate = shippingDate;
        this.shippingAddress = shippingAddress;
        this.shippingStatus = shippingStatus;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    private Long orderId;

    @Column(name = "ORDER_DATE")
    private LocalDateTime dateOfOrder;

    @Column(name = "SHIPPING_DATE")
    private LocalDateTime shippingDate;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "SHIPPING_STATUS")
    private String shippingStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;
}
