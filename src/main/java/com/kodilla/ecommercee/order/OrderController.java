package com.kodilla.ecommercee.order;

import com.kodilla.ecommercee.cart.NoFoundCartException;
import com.kodilla.ecommercee.user.NoFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping(value = "/getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orderMapper.mapToOrderDtoList(orders);
    }

    @GetMapping(value = "/getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId));
    }

    @PostMapping(value = "/postOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) throws NoFoundCartException, NoFoundUserException {
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.saveOrder(order);
    }

    @PutMapping(value = "/updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws NoFoundCartException, NoFoundUserException {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderService.saveOrder(order);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    @DeleteMapping(value = "/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) throws NoFoundUserException, NoFoundCartException {
        orderService.deleteOrderById(orderId);
    }
}