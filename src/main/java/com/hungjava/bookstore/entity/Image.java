package com.hungjava.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(name = "is_icon")
    boolean isIcon;

    @Column(name = "url_image")
    String urlImage;

    @Column(name = "data_image", columnDefinition = "LONGTEXT")
    @Lob
    String dataImage;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book; // Thuộc quyển sách nào

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    Instant updatedAt;

}
