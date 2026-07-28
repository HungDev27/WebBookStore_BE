package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.request.CartItemRequest;
import com.hungjava.bookstore.dto.response.CartItemResponse;
import java.util.List;

public interface CartItemService {
    CartItemResponse addToCart(Integer userId, CartItemRequest request);

    List<CartItemResponse> getCart(Integer userId);

    CartItemResponse updateQuantity(Integer userId, Integer cartItemId, Integer quantity);

    void deleteCartItem(Integer userId, Integer cartItemId);

    void clearCart(Integer userId);
}
