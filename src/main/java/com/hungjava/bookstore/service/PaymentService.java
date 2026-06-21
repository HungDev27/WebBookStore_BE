package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.request.PaymentRequest;
import com.hungjava.bookstore.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse create(PaymentRequest request);
    PaymentResponse update(int id, PaymentRequest request);
    void delete(int id);
    PaymentResponse getById(int id);
    List<PaymentResponse> getAll();
}
