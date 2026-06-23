package com.hungjava.bookstore.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    String fullName;
    String phone;
    String deliveryAddress;
    String note;
    int paymentId;
    int deliveryId;
    List<Integer> cartItemIds; // Dsách ID sản phẩm trong giỏ hàng để mua
}
