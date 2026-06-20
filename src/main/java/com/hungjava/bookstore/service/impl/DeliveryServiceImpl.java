package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.dto.request.DeliveryRequest;
import com.hungjava.bookstore.dto.response.DeliveryResponse;
import com.hungjava.bookstore.entity.Delivery;
import com.hungjava.bookstore.exception.ApiException;
import com.hungjava.bookstore.exception.ErrorCode;
import com.hungjava.bookstore.mapper.DeliveryMapper;
import com.hungjava.bookstore.repository.DeliveryRepository;
import com.hungjava.bookstore.repository.OrderRepository;
import com.hungjava.bookstore.service.DeliveryService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeliveryServiceImpl implements DeliveryService {
    DeliveryRepository deliveryRepository;
    OrderRepository orderRepository;
    DeliveryMapper deliveryMapper;

    @Override
    public DeliveryResponse create(DeliveryRequest request) {
        Delivery delivery = deliveryMapper.toDelivery(request);
        delivery = deliveryRepository.save(delivery);
        return deliveryMapper.toDeliveryResponse(delivery);
    }

    @Override
    @Transactional
    public DeliveryResponse update(int id, DeliveryRequest request) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.DELIVERY_NOT_FOUND));

        boolean inUse = orderRepository.existsByDeliveryId(id);
        if (inUse) {
            throw new ApiException(ErrorCode.DELIVERY_IN_USE);
        }

        deliveryMapper.updateDelivery(delivery, request);
        delivery = deliveryRepository.save(delivery);
        return deliveryMapper.toDeliveryResponse(delivery);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.DELIVERY_NOT_FOUND));

        boolean inUse = orderRepository.existsByDeliveryId(id);
        if (inUse) {
            throw new ApiException(ErrorCode.DELIVERY_IN_USE);
        }

        deliveryRepository.delete(delivery);
    }

    @Override
    public DeliveryResponse getById(int id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.DELIVERY_NOT_FOUND));
        return deliveryMapper.toDeliveryResponse(delivery);
    }

    @Override
    public List<DeliveryResponse> getAll() {
        return deliveryRepository.findAll().stream()
                .map(deliveryMapper::toDeliveryResponse)
                .toList();
    }
}
