package com.hungjava.bookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    Integer id;
    Integer bookId;
    String bookName;
    String bookImage;
    BigDecimal sellPrice;
    int quantity;
    BigDecimal subTotal;
}
