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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String fullName;

    String phone;

    @Column(name = "delivery_address")
    String deliveryAddress; // Địa chỉ giao hàng

    @Column(name = "total_price_product")
    BigDecimal totalPriceProduct;

    @Column(name = "fee_delivery")
    BigDecimal feeDelivery; // Chi phí giao hàng

    @Column(name = "fee_payment")
    BigDecimal feePayment; // Chi phí thanh toán

    @Column(name = "total_price")
    BigDecimal totalPrice;

    String status; // Trạng thái của đơn hàng

    String note; // Ghi chú

    @OneToMany(mappedBy = "order")
    List<OrderDetail> listOrderDetails; // Danh sách chi tiết đơn hàng

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user; // Người dùng

    @ManyToOne
    @JoinColumn(name = "payment_id")
    Payment payment; // Hình thức thanh toán

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    Delivery delivery; // Hình thức giao hàng

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    Instant updatedAt;
}