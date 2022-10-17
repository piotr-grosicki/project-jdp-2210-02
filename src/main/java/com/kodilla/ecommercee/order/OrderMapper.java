package com.kodilla.ecommercee.order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getDateOfOrder(),
                orderDto.getShippingDate(),
                orderDto.getShippingAddress(),
                orderDto.getShippingStatus()
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getDateOfOrder(),
                order.getShippingDate(),
                order.getShippingAddress(),
                order.getShippingStatus()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
