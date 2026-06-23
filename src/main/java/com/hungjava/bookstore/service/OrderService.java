package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.request.CancelOrderRequest;
import com.hungjava.bookstore.dto.request.OrderRequest;
import com.hungjava.bookstore.dto.request.UpdateOrderStatusRequest;
import com.hungjava.bookstore.dto.response.OrderResponse;
import com.hungjava.bookstore.entity.Order;

public interface OrderService {
    OrderResponse createOrderCOD(Integer userId, OrderRequest request);
    void cancelOrderCOD(CancelOrderRequest request, Integer userId);
    OrderResponse updateStatusOrderCOD(UpdateOrderStatusRequest request);
}
