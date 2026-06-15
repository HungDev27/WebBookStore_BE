package com.hungjava.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int quantity;

    BigDecimal price;

    @Column(name = "is_review")
    boolean isReview; // đã đánh giá chưa

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
     Book book;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    Order order; 

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    Instant updatedAt;
}
