package com.hungjava.bookstore.mapper;

import com.hungjava.bookstore.dto.request.DeliveryRequest;
import com.hungjava.bookstore.dto.response.DeliveryResponse;
import com.hungjava.bookstore.entity.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {
    public DeliveryResponse toDeliveryResponse(Delivery delivery) {
        if (delivery == null) {
            return null;
        }
        return DeliveryResponse.builder()
                .id(delivery.getId())
                .name(delivery.getName())
                .feeDelivery(delivery.getFeeDelivery())
                .description(delivery.getDescription())
                .createdAt(delivery.getCreatedAt())
                .updatedAt(delivery.getUpdatedAt())
                .build();
    }

    public Delivery toDelivery(DeliveryRequest request) {
        if (request == null) {
            return null;
        }
        return Delivery.builder()
                .name(request.getName())
                .feeDelivery(request.getFeeDelivery())
                .description(request.getDescription())
                .build();
    }

    public void updateDelivery(Delivery delivery, DeliveryRequest request) {
        if (delivery == null || request == null) {
            return;
        }
        delivery.setName(request.getName());
        delivery.setFeeDelivery(request.getFeeDelivery());
        delivery.setDescription(request.getDescription());
    }
}
