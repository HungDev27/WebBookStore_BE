package com.hungjava.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String content;

    @Column(name = "rating_point")
    float ratingPoint; // Điểm xếp hạng

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book; // Đánh giá quyển sách nào

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user; // Người dùng (ai là người đánh giá)

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    OrderDetail orderDetail;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;
}
