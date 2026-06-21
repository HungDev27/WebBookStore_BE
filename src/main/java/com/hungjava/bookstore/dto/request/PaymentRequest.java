package com.hungjava.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    @NotBlank(message = "Tên phương thức thanh toán không được để trống")
    String name;

    String description;

    @Min(value = 0, message = "Chi phí thanh toán phải lớn hơn hoặc bằng 0")
    BigDecimal feePayment;
}
