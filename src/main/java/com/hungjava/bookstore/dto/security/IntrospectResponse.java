package com.hungjava.bookstore.dto.security;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
// Lớp IntrospectResponse (Trả về true/false xem token còn sống không)
public class IntrospectResponse {
    boolean valid; // Cờ hợp lệ
}