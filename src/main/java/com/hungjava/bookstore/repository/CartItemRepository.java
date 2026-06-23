package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.book.id = :bookId")
    void deleteByBookId(@Param("bookId") Integer bookId);

    List<CartItem> findAllByIdInAndUserId(List<Integer> ids, Integer userId);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.user.id = :userId")
    void deleteByUserId(@Param("userId") Integer userId);


}
