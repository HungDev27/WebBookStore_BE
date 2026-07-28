package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.request.CartItemRequest;
import com.hungjava.bookstore.dto.response.CartItemResponse;
import com.hungjava.bookstore.service.CartItemService;
import com.hungjava.bookstore.utils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<ApiResponse<CartItemResponse>> addToCart(@Valid @RequestBody CartItemRequest request) {
        Integer userId = SecurityUtils.getCurrentUserId();
        CartItemResponse response = cartItemService.addToCart(userId, request);
        return ResponseEntity.status(201).body(ApiResponse.<CartItemResponse>builder()
                .success(true)
                .data(response)
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CartItemResponse>>> getCart() {
        Integer userId = SecurityUtils.getCurrentUserId();
        List<CartItemResponse> response = cartItemService.getCart(userId);
        return ResponseEntity.ok(ApiResponse.<List<CartItemResponse>>builder()
                .success(true)
                .data(response)
                .build());
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse<CartItemResponse>> updateQuantity(
            @PathVariable Integer cartItemId,
            @RequestParam int quantity) {
        Integer userId = SecurityUtils.getCurrentUserId();
        CartItemResponse response = cartItemService.updateQuantity(userId, cartItemId, quantity);
        return ResponseEntity.ok(ApiResponse.<CartItemResponse>builder()
                .success(true)
                .data(response)
                .build());
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse<Void>> deleteCartItem(@PathVariable Integer cartItemId) {
        Integer userId = SecurityUtils.getCurrentUserId();
        cartItemService.deleteCartItem(userId, cartItemId);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .success(true)
                .build());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<ApiResponse<Void>> clearCart() {
        Integer userId = SecurityUtils.getCurrentUserId();
        cartItemService.clearCart(userId);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .success(true)
                .build());
    }
}
