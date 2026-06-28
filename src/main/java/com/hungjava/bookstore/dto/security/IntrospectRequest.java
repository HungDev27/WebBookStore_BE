package com.hungjava.bookstore.dto.security;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
// Lớp IntrospectRequest (Để gửi token lên kiểm tra)
public class IntrospectRequest {
    @NotBlank(message = "Token không được để trống")
    String token;
}
