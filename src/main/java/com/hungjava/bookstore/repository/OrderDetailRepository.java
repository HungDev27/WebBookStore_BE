package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    boolean existsByBookId(Integer bookId);
}
