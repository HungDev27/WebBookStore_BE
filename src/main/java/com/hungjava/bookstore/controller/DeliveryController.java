package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.request.DeliveryRequest;
import com.hungjava.bookstore.dto.response.DeliveryResponse;
import com.hungjava.bookstore.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/deliveries")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeliveryController {
    DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<ApiResponse<DeliveryResponse>> create(@Valid @RequestBody DeliveryRequest request) {
        return ResponseEntity.status(201).body(ApiResponse.<DeliveryResponse>builder()
                .success(true)
                .data(deliveryService.create(request))
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DeliveryResponse>>> getAll() {
        return ResponseEntity.ok(ApiResponse.<List<DeliveryResponse>>builder()
                .success(true)
                .data(deliveryService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryResponse>> getById(@PathVariable int id) {
        return ResponseEntity.ok(ApiResponse.<DeliveryResponse>builder()
                .success(true)
                .data(deliveryService.getById(id))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryResponse>> update(@PathVariable int id, @Valid @RequestBody DeliveryRequest request) {
        return ResponseEntity.ok(ApiResponse.<DeliveryResponse>builder()
                .success(true)
                .data(deliveryService.update(id, request))
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
        deliveryService.delete(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .success(true)
                .build());
    }
}
