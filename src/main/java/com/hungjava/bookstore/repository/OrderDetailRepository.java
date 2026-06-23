package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.Order;
import com.hungjava.bookstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    boolean existsByBookId(Integer bookId);
    // Tìm danh sách chi tiết đơn hàng bằng Order
    List<OrderDetail> findOrderDetailsByOrder(Order order);
}
