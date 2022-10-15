package com.kodilla.ecommercee.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order")
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
}
