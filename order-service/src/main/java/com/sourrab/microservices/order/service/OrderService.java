package com.sourrab.microservices.order.service;

import com.sourrab.microservices.order.dto.OrderRequest;
import com.sourrab.microservices.order.dto.OrderResponse;
import com.sourrab.microservices.order.model.Order;
import com.sourrab.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .skuCode(orderRequest.skuCode())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .build();
        orderRepository.save(order);
        return new OrderResponse(order.getId(), order.getOrderNumber(), orderRequest.skuCode(), orderRequest.price(), orderRequest.quantity());
    }
}
