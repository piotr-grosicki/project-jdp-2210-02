package com.kodilla.ecommercee.order;

import com.kodilla.ecommercee.cart.Cart;
import com.kodilla.ecommercee.cart.CartRepository;
import com.kodilla.ecommercee.cart.NoFoundCartException;
import com.kodilla.ecommercee.user.NoFoundUserException;
import com.kodilla.ecommercee.user.User;
import com.kodilla.ecommercee.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void createOrder(OrderDto orderDto) throws NoFoundUserException, NoFoundCartException {
        if (!cartRepository.existsById(orderDto.getCartId()))
            throw new NoFoundCartException();
        Order newOrder = orderMapper.mapToOrder(orderDto);
        orderRepository.save(newOrder);
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow(NoFoundCartException::new);
        cart.setOrder(newOrder);
        cartRepository.save(cart);
        User user = userRepository.findById(cart.getUser().getId()).orElseThrow(NoFoundUserException::new);
        user.setOrder(newOrder);
        userRepository.save(user);
    }
}