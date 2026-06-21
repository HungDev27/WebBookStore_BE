package com.hungjava.bookstore.mapper;

import com.hungjava.bookstore.dto.request.PaymentRequest;
import com.hungjava.bookstore.dto.response.PaymentResponse;
import com.hungjava.bookstore.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public PaymentResponse toPaymentResponse(Payment payment) {
        if (payment == null) {
            return null;
        }
        return PaymentResponse.builder()
                .id(payment.getId())
                .name(payment.getName())
                .description(payment.getDescription())
                .feePayment(payment.getFeePayment())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }

    public Payment toPayment(PaymentRequest request) {
        if (request == null) {
            return null;
        }
        return Payment.builder()
                .name(request.getName())
                .description(request.getDescription())
                .feePayment(request.getFeePayment())
                .build();
    }

    public void updatePayment(Payment payment, PaymentRequest request) {
        if (payment == null || request == null) {
            return;
        }
        payment.setName(request.getName());
        payment.setDescription(request.getDescription());
        payment.setFeePayment(request.getFeePayment());
    }
}
