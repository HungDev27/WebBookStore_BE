package com.hungjava.bookstore.mapper;

import com.hungjava.bookstore.dto.request.OrderRequest;
import com.hungjava.bookstore.dto.response.OrderResponse;
import com.hungjava.bookstore.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponse toOrderResponse(Order order) {
        if (order == null) {
            return null;
        }
        return OrderResponse.builder()
                .id(order.getId())
                .fullName(order.getFullName())
                .phone(order.getPhone())
                .deliveryAddress(order.getDeliveryAddress())
                .note(order.getNote())
                .paymentName(order.getPayment() != null ? order.getPayment().getName() : null)
                .deliveryName(order.getDelivery() != null ? order.getDelivery().getName() : null)
                .userName(order.getUser() != null ? order.getUser().getFullName() : null)
                .totalPriceProduct(order.getTotalPriceProduct())
                .feeDelivery(order.getFeeDelivery())
                .feePayment(order.getFeePayment())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public Order toOrder(OrderRequest request) {
        if (request == null) {
            return null;
        }
        return Order.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .deliveryAddress(request.getDeliveryAddress())
                .note(request.getNote())
                .build();
    }
}
