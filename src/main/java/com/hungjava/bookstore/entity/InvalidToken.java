package com.hungjava.bookstore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Đánh dấu là bảng lưu danh sách đen các token
@Table(name = "invalid_tokens") // Tên bảng
public class InvalidToken {
    @Id // Khóa chính chính là ID của JWT (chuỗi UUID)
    String id;

    // Lưu thời gian hết hạn, để sau này có thể tự động dọn dẹp các token rác khỏi Database
    LocalDateTime expiryTime;
}
