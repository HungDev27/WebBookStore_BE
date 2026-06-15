package com.hungjava.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String author;

    String description;

    @Column(name = "list_price")
    BigDecimal listPrice; // Giá niêm yết

    @Column(name = "sell_price")
    BigDecimal sellPrice;

    int quantity;

    @Column(name = "avg_rating")
    double avgRating; // Trung bình xếp hạng

    @Column(name = "sold_quantity")
    int soldQuantity; // Đã bán bao nhiêu

    @Column(name = "discount_percent")
    int discountPercent; // Giảm giá bao nhiêu %

    @ManyToMany
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    List<Genre> listGenres; // Danh sách thể loại

    @OneToMany(mappedBy = "book")
    List<Image> listImages; // Danh sách ảnh


    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    Instant updatedAt;
}

