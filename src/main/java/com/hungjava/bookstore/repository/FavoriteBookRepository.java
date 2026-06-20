package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Integer> {
    @Modifying
    @Query("DELETE FROM FavoriteBook f WHERE f.book.id = :bookId")
    void deleteByBookId(@Param("bookId") Integer bookId);
}
