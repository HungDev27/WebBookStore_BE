package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.request.DeliveryRequest;
import com.hungjava.bookstore.dto.response.DeliveryResponse;

import java.util.List;

public interface DeliveryService {
    DeliveryResponse create(DeliveryRequest request);
    DeliveryResponse update(int id, DeliveryRequest request);
    void delete(int id);
    DeliveryResponse getById(int id);
    List<DeliveryResponse> getAll();
}
