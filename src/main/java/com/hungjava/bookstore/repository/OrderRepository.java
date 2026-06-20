package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    boolean existsByDeliveryId(Integer deliveryId);
}
