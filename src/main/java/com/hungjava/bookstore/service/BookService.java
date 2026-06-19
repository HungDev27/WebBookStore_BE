package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.PageResponse;
import com.hungjava.bookstore.dto.request.BookCreateRequest;
import com.hungjava.bookstore.dto.response.BookListResponse;
import com.hungjava.bookstore.dto.response.BookResponse;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface BookService {
    BookResponse addBook(BookCreateRequest request);
    PageResponse<BookListResponse> getAllBooks(
            String search, 
            Integer genreId, 
            BigDecimal minPrice, 
            BigDecimal maxPrice,
            Integer rating,
            Pageable pageable
    );
}
