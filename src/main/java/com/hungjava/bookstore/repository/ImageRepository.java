package com.hungjava.bookstore.repository;

import com.hungjava.bookstore.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Modifying
    @Query("DELETE FROM Image i WHERE i.book.id = :bookId")
    void deleteByBookId(@Param("bookId") Integer bookId);

    List<Image> findByBookId(Integer bookId);
}
