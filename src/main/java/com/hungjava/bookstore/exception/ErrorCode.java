package com.hungjava.bookstore.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    // Lỗi ứng dụng
    USER_NOT_FOUND("Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
    BOOK_NOT_FOUND("Không tìm thấy sách", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_FOUND("Không tìm thấy danh mục", HttpStatus.NOT_FOUND),
    REVIEW_NOT_FOUND("Không tìm thấy đánh giá", HttpStatus.NOT_FOUND),
    GENRE_NOT_FOUND("Không tìm thấy thể loại", HttpStatus.NOT_FOUND),

    //Lỗi hệ thống & phân quyền
    UNAUTHORIZED("Bạn chưa đăng nhập", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("Bạn không có quyền truy cập", HttpStatus.FORBIDDEN);

    String message;
    HttpStatus status;
}
