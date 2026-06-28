package com.hungjava.bookstore.dto.security;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
// Lớp LogoutRequest (Để gửi Token muốn hủy)
public class LogoutRequest {
    @NotBlank(message = "Token không được để trống")
    String token;
}
