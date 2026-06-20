package com.hungjava.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryRequest {
    @NotBlank(message = "Tên gói vận chuyển không được để trống")
    String name;

    @NotNull(message = "Chi phí vận chuyển không được để trống")
    @Min(value = 0, message = "Chi phí vận chuyển phải lớn hơn hoặc bằng 0")
    BigDecimal feeDelivery;

    String description;
}
