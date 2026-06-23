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
    DELIVERY_NOT_FOUND("Không tìm thấy phương thức vận chuyển", HttpStatus.NOT_FOUND),
    DELIVERY_IN_USE("Phương thức vận chuyển đã được sử dụng trong đơn hàng, không thể xóa", HttpStatus.BAD_REQUEST),
    PAYMENT_IN_USE("Phương thức thanh toán đã được sử dụng trong đơn hàng, không thể xóa", HttpStatus.BAD_REQUEST),
    PAYMENT_NOT_FOUND("Không tìm thấy phương thức thanh toán", HttpStatus.NOT_FOUND),
    CART_EMPTY("Giỏ hàng của người dùng trống", HttpStatus.BAD_REQUEST),
    INVALID_PAYMENT_METHOD("Phương thức thanh toán phải là Tiền mặt (COD)", HttpStatus.BAD_REQUEST),
    OUT_OF_STOCK("Số lượng sách trong kho không đủ", HttpStatus.BAD_REQUEST),
    ORDER_NOT_FOUND("Không tìm thấy đơn đặt hàng",HttpStatus.NOT_FOUND),
    CANNOT_CANCEL_ORDER("Đơn hàng đang giao hoặc đã giao, không thể hủy",HttpStatus.BAD_REQUEST),
    //Lỗi hệ thống & phân quyền
    UNAUTHORIZED("Bạn chưa đăng nhập", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("Bạn không có quyền truy cập", HttpStatus.FORBIDDEN);

    String message;
    HttpStatus status;
}
