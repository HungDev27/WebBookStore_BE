package com.hungjava.bookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryResponse {
    int id;
    String name;
    BigDecimal feeDelivery;
    String description;
    Instant createdAt;
    Instant updatedAt;
}
