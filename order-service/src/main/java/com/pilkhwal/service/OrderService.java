package com.pilkhwal.service;

import com.pilkhwal.dto.OrderRequest;
import com.pilkhwal.dto.OrderResponse;
import com.pilkhwal.model.Order;
import com.pilkhwal.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestClient client;

    public String placeOrder(OrderRequest orderRequest) {

        boolean isValid = Boolean.TRUE.equals(client.get()
                        .uri(uriBuilder -> uriBuilder
                                .queryParam("skuCode", orderRequest.skuCode())
                                .queryParam("quantity", orderRequest.quantity())
                                .build())
                .retrieve()
                .body(Boolean.class));

        if(isValid) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(orderRequest.price())
                    .skuCode(orderRequest.skuCode())
                    .quantity(orderRequest.quantity())
                    .build();
            orderRepository.save(order);

            return "Order place successfully";
        }

        return "product with skuCode" + orderRequest.skuCode() + " is not in stock.";
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
