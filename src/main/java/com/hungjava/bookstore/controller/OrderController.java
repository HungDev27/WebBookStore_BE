package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.request.CancelOrderRequest;
import com.hungjava.bookstore.dto.request.OrderRequest;
import com.hungjava.bookstore.dto.request.UpdateOrderStatusRequest;
import com.hungjava.bookstore.dto.response.CancelOrderResponse;
import com.hungjava.bookstore.dto.response.OrderResponse;
import com.hungjava.bookstore.service.OrderService;
import com.hungjava.bookstore.utils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<ApiResponse<OrderResponse>> createOrderCOD(@Valid @RequestBody OrderRequest orderRequest) {
        Integer userId = SecurityUtils.getCurrentUserId();
        OrderResponse response = orderService.createOrderCOD(userId, orderRequest);

        return ResponseEntity.status(201).body(ApiResponse.<OrderResponse>builder()
                .success(true)
                .data(response)
                .build());
    }

    @PutMapping("/cancel-order")
    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER', 'ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<?>> cancelOrder(@Valid @RequestBody CancelOrderRequest request) {
        Integer userId = SecurityUtils.getCurrentUserId();
        orderService.cancelOrderCOD(request, userId);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(CancelOrderResponse.builder()
                        .message("Hủy đơn hàng thành công !!!")
                        .build())
                .build());
    }

    @PutMapping("/update-status-order")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<?>> updateStatusOrder(@Valid @RequestBody UpdateOrderStatusRequest request) {
        OrderResponse response = orderService.updateStatusOrderCOD(request);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(response)
                .build());
    }
}
