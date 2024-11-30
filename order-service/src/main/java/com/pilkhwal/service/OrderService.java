package com.pilkhwal.service;

import com.pilkhwal.dto.OrderRequest;
import com.pilkhwal.dto.OrderResponse;
import com.pilkhwal.model.Order;
import com.pilkhwal.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();

        orderRepository.save(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream().map(order -> new OrderResponse(
                        order.getId(),
                        order.getOrderNumber(),
                        order.getSkuCode(),
                        order.getPrice(),
                        order.getQuantity()
                )).toList();
    }
}
