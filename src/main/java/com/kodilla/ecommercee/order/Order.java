package com.kodilla.ecommercee.order;

import com.kodilla.ecommercee.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long orderId;

    @Column(name = "ORDER_DATE")
    private LocalDateTime dateOfOrder;

    @Column(name = "SHIPPING_DATE")
    private LocalDateTime shippingDate;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "SHIPPING_STATUS")
    private String shippingStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;
}
