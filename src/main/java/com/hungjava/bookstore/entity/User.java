package com.hungjava.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name")
    String fullName;

    @Column( unique = true)
    String username;

    String password;

    String email;

    LocalDate dob;

    String gender;

    String avatar;

    String phone;

    @Column(name = "billing_address")
    String billingAddress; // Địa chỉ mua hàng/thanh toán

    @Column(name = "shipping_address")
    String shippingAddress; // Địa chỉ giao hàng

    String status; // inactive/active

    @Column(name = "hash_active")
    String hashActive; // mã kích hoạt

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    List<Role> roles; // Quyen -> Role

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;

}
