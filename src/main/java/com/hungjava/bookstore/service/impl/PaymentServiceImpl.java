package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.dto.request.PaymentRequest;
import com.hungjava.bookstore.dto.response.PaymentResponse;
import com.hungjava.bookstore.entity.Payment;
import com.hungjava.bookstore.exception.ApiException;
import com.hungjava.bookstore.exception.ErrorCode;
import com.hungjava.bookstore.mapper.PaymentMapper;
import com.hungjava.bookstore.repository.OrderRepository;
import com.hungjava.bookstore.repository.PaymentRepository;
import com.hungjava.bookstore.service.PaymentService;
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
public class PaymentServiceImpl implements PaymentService {
    PaymentRepository paymentRepository;
    OrderRepository orderRepository;
    PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentResponse create(PaymentRequest request) {
        Payment payment = paymentMapper.toPayment(request);
        payment = paymentRepository.save(payment);
        return paymentMapper.toPaymentResponse(payment);
    }

    @Override
    @Transactional
    public PaymentResponse update(int id, PaymentRequest request) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.PAYMENT_NOT_FOUND));
        paymentMapper.updatePayment(payment, request);
        payment = paymentRepository.save(payment);
        return paymentMapper.toPaymentResponse(payment);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.PAYMENT_NOT_FOUND));

        // Kiểm tra xem phương thức thanh toán này có đang được sử dụng trong đơn hàng nào không
        boolean inUse = orderRepository.existsByPaymentId(id);
        if (inUse) {
            throw new ApiException(ErrorCode.PAYMENT_IN_USE);
        }

        paymentRepository.delete(payment);
    }

    @Override
    public PaymentResponse getById(int id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.PAYMENT_NOT_FOUND));
        return paymentMapper.toPaymentResponse(payment);
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toPaymentResponse)
                .collect(Collectors.toList());
    }
}
