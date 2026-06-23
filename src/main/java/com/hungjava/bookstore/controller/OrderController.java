package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.request.CancelOrderRequest;
import com.hungjava.bookstore.dto.request.OrderRequest;
import com.hungjava.bookstore.dto.request.UpdateOrderStatusRequest;
import com.hungjava.bookstore.dto.response.CancelOrderResponse;
import com.hungjava.bookstore.dto.response.OrderResponse;
import com.hungjava.bookstore.service.OrderService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrderCOD(@Valid @RequestBody OrderRequest orderRequest) {
        // Lấy userId từ Context Đăng nhập (JwtToken / Session)
        // Spring Security:
        // userId = ((UserPrincipal)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Integer mockUserId = 1; // Tạm thời hardcode

        OrderResponse response = orderService.createOrderCOD(mockUserId, orderRequest);

        return ResponseEntity.status(201).body(ApiResponse.<OrderResponse>builder()
                .success(true)
                .data(response)
                .build());
    }

    @PutMapping("/cancel-order")
    public ResponseEntity<ApiResponse<?>> cancelOrder(@Valid @RequestBody CancelOrderRequest request) {
        Integer mockUserId = 1;

        orderService.cancelOrderCOD(request, mockUserId);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(CancelOrderResponse.builder()
                        .message("Hủy đơn hàng thành công !!!")
                        .build())
                .build());
    }

    @PutMapping("/update-status-order")
    public ResponseEntity<ApiResponse<?>> cancelOrder(@Valid @RequestBody UpdateOrderStatusRequest request) {
        Integer mockUserId = 1;

        OrderResponse response = orderService.updateStatusOrderCOD(request);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(response)
                .build());
    }
}
