package com.kodilla.ecommercee;

import com.kodilla.ecommercee.order.Order;
import com.kodilla.ecommercee.order.OrderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void createOrder() {
        //Given
        Order order = new Order(65465465L, LocalDateTime.now(), LocalDateTime.now(), "sdfgsdg", "fghsfh");
        //When
        orderRepository.save(order);
        //Then
        assertEquals(1, orderRepository.count());
        assertTrue(orderRepository.existsById(order.getOrderId()));
        //CleanUp
        orderRepository.deleteById(order.getOrderId());
    }
}
