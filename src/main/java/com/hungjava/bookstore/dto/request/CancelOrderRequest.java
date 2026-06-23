package com.hungjava.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CancelOrderRequest {
    @NotNull(message = "Id đơn hàng không được để trống")
    @Min(value = 1, message = "Id đơn hàng không hợp lệ")
    Integer id;
    String reason;
}
