package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.PageResponse;
import com.hungjava.bookstore.dto.request.BookCreateRequest;
import com.hungjava.bookstore.dto.request.BookUpdateRequest;
import com.hungjava.bookstore.dto.response.BookListResponse;
import com.hungjava.bookstore.dto.response.BookResponse;
import com.hungjava.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("${api.prefix}/books")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;

    // POST: Sử dụng @ModelAttribute thay vì @RequestBody vì BookRequest chứa danh sách file ảnh MultipartFile)
    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> create(@Valid @ModelAttribute BookCreateRequest request) {
        return ResponseEntity.status(201).body(ApiResponse.<BookResponse>builder()
                .success(true)
                .data(bookService.addBook(request))
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<BookListResponse>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) String search, // tìm kiếm theo tên tác giả hoặc tên sách
            @RequestParam(required = false) Integer genreId, // lọc theo id của genre để id for ra tên thể loại
            @RequestParam(required = false) BigDecimal minPrice, // lọc theo khoảng giá từ min->max
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Integer rating, // lọc theo sao từ 1-5
            @RequestParam(defaultValue = "newest") String sortBy // sort theo createAt
    ) {

        Sort sort = Sort.by("createdAt").descending();
        if ("oldest".equalsIgnoreCase(sortBy) || "old".equalsIgnoreCase(sortBy)) {
            sort = Sort.by("createdAt").ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        PageResponse<BookListResponse> data = bookService.getAllBooks(search, genreId, minPrice, maxPrice, rating, pageable);
        return ResponseEntity.ok(ApiResponse.<PageResponse<BookListResponse>>builder()
                .success(true)
                .data(data)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getById(@PathVariable int id) {
        return ResponseEntity.ok(ApiResponse.<BookResponse>builder()
                .success(true)
                .data(bookService.getById(id))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> update(@PathVariable int id, @Valid @ModelAttribute BookUpdateRequest request) {
        return ResponseEntity.ok(ApiResponse.<BookResponse>builder()
                .success(true)
                .data(bookService.updateBook(id, request))
                .build());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
//        bookService.delete(id);
//        return ResponseEntity.ok(ApiResponse.<Void>builder()
//                .success(true)
//                .build());
//    }

}
