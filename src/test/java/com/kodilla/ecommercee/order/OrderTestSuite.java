package com.kodilla.ecommercee.order;

import com.kodilla.ecommercee.cart.Cart;
import com.kodilla.ecommercee.cart.CartRepository;
import com.kodilla.ecommercee.group.GroupRepository;
import com.kodilla.ecommercee.order.Order;
import com.kodilla.ecommercee.order.OrderRepository;
import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.product.ProductRepository;
import com.kodilla.ecommercee.user.User;
import com.kodilla.ecommercee.user.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void createOrder() {
        //Given
        Order order = new Order(4564L, LocalDateTime.now(), LocalDateTime.now(), "dfdfg", "sdsdsds");
        //When
        orderRepository.save(order);
        //Then
        assertEquals(1, orderRepository.count());
        assertTrue(orderRepository.existsById(order.getOrderId()));
        //CleanUp
        orderRepository.deleteById(order.getOrderId());
    }
}
