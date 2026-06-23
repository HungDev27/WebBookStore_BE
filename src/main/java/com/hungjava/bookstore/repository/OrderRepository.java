package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    boolean existsByDeliveryId(Integer deliveryId);
    boolean existsByPaymentId(Integer paymentId);

    // Tìm đơn hàng theo đúng ID và đúng người mua
    Optional<Order> findByIdAndUserId(Integer id, Integer userId);
}
