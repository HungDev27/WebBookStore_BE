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
public class CartItemRequest {
    @NotNull(message = "ID sách không được để trống")
    Integer bookId;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng sách phải tối thiểu là 1")
    Integer quantity;
}
