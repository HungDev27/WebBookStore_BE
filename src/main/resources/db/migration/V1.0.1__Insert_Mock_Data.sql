INSERT INTO roles (name) VALUES 
('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_MANAGER'), ('ROLE_STAFF'), ('ROLE_GUEST'), 
('ROLE_EDITOR'), ('ROLE_MODERATOR'), ('ROLE_SUPPORT'), ('ROLE_ANALYST'), ('ROLE_DEVELOPER');

INSERT INTO users (full_name, username, password, email, dob, gender, avatar, phone, status, hash_active, billing_address, shipping_address) VALUES
('Nguyễn Văn A', 'admin', '$2a$10$xyz', 'admin@bookstore.vn', '1990-01-01', 'Nam', NULL, '0901234560', 'ACTIVE', NULL, 'Hà Nội', 'Hà Nội'),
('Trần Thị B', 'user', '$2a$10$xyz', 'user@bookstore.vn', '1995-05-05', 'Nữ', NULL, '0901234561', 'ACTIVE', NULL, 'TP. Hồ Chí Minh', 'TP. Hồ Chí Minh'),
('Lê Hoàng C', 'hoangc', '$2a$10$xyz', 'hoangc@bookstore.vn', '1992-02-02', 'Nam', NULL, '0901234562', 'ACTIVE', NULL, 'Đà Nẵng', 'Đà Nẵng'),
('Phạm Thị D', 'phamd', '$2a$10$xyz', 'phamd@bookstore.vn', '1993-03-03', 'Nữ', NULL, '0901234563', 'ACTIVE', NULL, 'Huế', 'Huế'),
('Hoàng Văn E', 'hoange', '$2a$10$xyz', 'hoange@bookstore.vn', '1985-04-04', 'Nam', NULL, '0901234564', 'INACTIVE', NULL, 'Cần Thơ', 'Cần Thơ'),
('Đinh Thị F', 'dinhf', '$2a$10$xyz', 'dinhf@bookstore.vn', '1998-06-06', 'Nữ', NULL, '0901234565', 'ACTIVE', NULL, 'Hải Phòng', 'Hải Phòng'),
('Lý Công G', 'lyg', '$2a$10$xyz', 'lyg@bookstore.vn', '1991-07-07', 'Nam', NULL, '0901234566', 'ACTIVE', NULL, 'Nha Trang', 'Nha Trang'),
('Trần Kiều H', 'tranh', '$2a$10$xyz', 'tranh@bookstore.vn', '1994-08-08', 'Nữ', NULL, '0901234567', 'ACTIVE', NULL, 'Đà Lạt', 'Đà Lạt'),
('Vũ Đức I', 'vui', '$2a$10$xyz', 'vui@bookstore.vn', '1989-09-09', 'Nam', NULL, '0901234568', 'LOCKED', NULL, 'Vũng Tàu', 'Vũng Tàu'),
('Ngô Bảo K', 'ngok', '$2a$10$xyz', 'ngok@bookstore.vn', '1997-10-10', 'Nữ', NULL, '0901234569', 'ACTIVE', NULL, 'Quảng Ninh', 'Quảng Ninh');

INSERT INTO user_roles (user_id, role_id) VALUES 
(1, 1), (2, 2), (3, 2), (4, 2), (5, 2), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2);

INSERT INTO genres (name) VALUES 
('Khoa học viễn tưởng'), ('Văn học kinh điển'), ('Lãng mạn'), ('Trinh thám'), ('Huyền bí'),
('Lịch sử'), ('Kinh dị'), ('Tiểu sử'), ('Kỹ năng sống'), ('Lập trình');

INSERT INTO books (name, author, description, list_price, sell_price, quantity, avg_rating, sold_quantity, discount_percent) VALUES
('Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 'Tác phẩm văn học thiếu nhi kinh điển của Việt Nam.', 85000.00, 75000.00, 100, 4.8, 500, 12),
('Số Đỏ', 'Vũ Trọng Phụng', 'Tiểu thuyết trào phúng nổi tiếng.', 120000.00, 100000.00, 50, 4.9, 300, 16),
('Chữ Người Tử Tù', 'Nguyễn Tuân', 'Tác phẩm văn học xuất sắc.', 65000.00, 60000.00, 200, 4.7, 450, 8),
('Tắt Đèn', 'Ngô Tất Tố', 'Tác phẩm hiện thực phê phán.', 70000.00, 60000.00, 80, 4.6, 220, 14),
('Lão Hạc', 'Nam Cao', 'Truyện ngắn xuất sắc về người nông dân.', 55000.00, 50000.00, 60, 4.9, 250, 9),
('Mắt Biếc', 'Nguyễn Nhật Ánh', 'Truyện dài tình cảm lãng mạn.', 110000.00, 95000.00, 150, 4.8, 800, 13),
('Cho Tôi Xin Một Vé Đi Tuổi Thơ', 'Nguyễn Nhật Ánh', 'Hành trình trở về tuổi thơ tươi đẹp.', 80000.00, 75000.00, 90, 4.8, 600, 6),
('Đất Rừng Phương Nam', 'Đoàn Giỏi', 'Tiểu thuyết về vùng quê Nam Bộ.', 95000.00, 85000.00, 110, 4.7, 350, 10),
('Cánh Đồng Bất Tận', 'Nguyễn Ngọc Tư', 'Tập truyện ngắn nổi bật.', 90000.00, 80000.00, 300, 4.9, 500, 11),
('Sống Mòn', 'Nam Cao', 'Tiểu thuyết tâm lý xã hội.', 100000.00, 85000.00, 250, 4.8, 600, 15);

INSERT INTO book_genre (book_id, genre_id) VALUES 
(1, 2), (2, 2), (3, 2), (4, 2), (5, 2), (6, 3), (7, 3), (8, 6), (9, 3), (10, 2);

INSERT INTO images (name, is_icon, url_image, data_image, book_id) VALUES
('demen.jpg', true, 'http://bookstore.vn/images/demen.jpg', NULL, 1),
('sodo.jpg', true, 'http://bookstore.vn/images/sodo.jpg', NULL, 2),
('chunguoi.jpg', true, 'http://bookstore.vn/images/chunguoi.jpg', NULL, 3),
('tatden.jpg', true, 'http://bookstore.vn/images/tatden.jpg', NULL, 4),
('laohac.jpg', true, 'http://bookstore.vn/images/laohac.jpg', NULL, 5),
('matbiec.jpg', true, 'http://bookstore.vn/images/matbiec.jpg', NULL, 6),
('vetuoitho.jpg', true, 'http://bookstore.vn/images/vetuoitho.jpg', NULL, 7),
('datrung.jpg', true, 'http://bookstore.vn/images/datrung.jpg', NULL, 8),
('canhdong.jpg', true, 'http://bookstore.vn/images/canhdong.jpg', NULL, 9),
('songmon.jpg', true, 'http://bookstore.vn/images/songmon.jpg', NULL, 10);

INSERT INTO payments (name, description, fee_payment) VALUES
('Tiền mặt (COD)', 'Thanh toán khi nhận hàng', 0.0),
('Ví MoMo', 'Thanh toán qua ví điện tử MoMo', 5000.0),
('ZaloPay', 'Thanh toán qua ví ZaloPay', 5000.0),
('VNPay', 'Thanh toán qua cổng VNPay', 5000.0),
('Chuyển khoản', 'Chuyển khoản ngân hàng trực tiếp', 0.0),
('Thẻ ATM nội địa', 'Thanh toán bằng thẻ ATM', 3000.0),
('Thẻ Tín Dụng', 'Visa / Mastercard', 10000.0),
('ViettelPay', 'Thanh toán qua ViettelPay', 5000.0),
('ShopeePay', 'Thanh toán qua ví ShopeePay', 5000.0),
('Apple Pay', 'Thanh toán qua Apple Pay', 15000.0);

INSERT INTO deliveries (name, description, fee_delivery) VALUES
('Giao hàng tiêu chuẩn', 'Từ 3-5 ngày', 25000.0),
('Giao hàng nhanh', 'Từ 1-2 ngày', 40000.0),
('Giao hỏa tốc', 'Nhận trong ngày', 80000.0),
('Giao hàng tiết kiệm (GHTK)', 'Từ 3-5 ngày', 22000.0),
('Viettel Post', 'Từ 2-4 ngày', 30000.0),
('VNPost', 'Từ 4-6 ngày', 20000.0),
('J&T Express', 'Từ 2-4 ngày', 28000.0),
('Ninja Van', 'Từ 3-5 ngày', 26000.0),
('Nhận tại cửa hàng', 'Khách đến tự lấy', 0.0),
('Ahamove', 'Giao nội thành siêu tốc', 50000.0);

INSERT INTO orders (delivery_address, phone, full_name, total_price_product, fee_delivery, fee_payment, total_price, status, note, user_id, payment_id, delivery_id) VALUES
('123 Xuân Thủy, Cầu Giấy, Hà Nội', '0901234561', 'Trần Thị B', 75000.00, 25000.0, 0.0, 100000.00, 'PENDING', 'Giao giờ hành chính', 2, 1, 1),
('456 Lê Lợi, Q1, TP.HCM', '0901234562', 'Lê Hoàng C', 100000.00, 40000.0, 5000.0, 145000.00, 'SHIPPED', 'Gọi trước khi giao', 3, 2, 2),
('789 Nguyễn Văn Linh, Đà Nẵng', '0901234563', 'Phạm Thị D', 60000.00, 22000.0, 0.0, 82000.00, 'DELIVERED', '', 4, 1, 4),
('101 Hùng Vương, Huế', '0901234564', 'Hoàng Văn E', 60000.00, 30000.0, 5000.0, 95000.00, 'CANCELLED', 'Khách đổi ý', 5, 3, 5),
('202 Trần Hưng Đạo, Cần Thơ', '0901234565', 'Đinh Thị F', 50000.00, 20000.0, 0.0, 70000.00, 'PENDING', 'Để trước cửa', 6, 1, 6),
('303 Lạch Tray, Hải Phòng', '0901234566', 'Lý Công G', 95000.00, 28000.0, 5000.0, 128000.00, 'SHIPPED', '', 7, 4, 7),
('404 Trần Phú, Nha Trang', '0901234567', 'Trần Kiều H', 75000.00, 26000.0, 0.0, 101000.00, 'DELIVERED', 'Bọc quà giúp mình', 8, 5, 8),
('505 Phù Đổng Thiên Vương, Đà Lạt', '0901234568', 'Vũ Đức I', 85000.00, 80000.0, 10000.0, 175000.00, 'PENDING', 'Giao nhanh trong chiều', 9, 7, 3),
('606 Bình Giã, Vũng Tàu', '0901234569', 'Ngô Bảo K', 80000.00, 50000.0, 5000.0, 135000.00, 'SHIPPED', '', 10, 8, 10),
('707 Lê Thánh Tông, Quảng Ninh', '0901234560', 'Nguyễn Văn A', 85000.00, 0.0, 0.0, 85000.00, 'DELIVERED', 'Đơn nội bộ', 1, 1, 9);

INSERT INTO order_details (quantity, price, is_review, book_id, order_id) VALUES
(1, 75000.00, false, 1, 1),
(1, 100000.00, true, 2, 2),
(1, 60000.00, false, 3, 3),
(1, 60000.00, true, 4, 4),
(1, 50000.00, false, 5, 5),
(1, 95000.00, true, 6, 6),
(1, 75000.00, false, 7, 7),
(1, 85000.00, true, 8, 8),
(1, 80000.00, false, 9, 9),
(1, 85000.00, true, 10, 10);

INSERT INTO reviews (content, rating_point, book_id, user_id, order_detail_id) VALUES
('Truyện rất hay và ý nghĩa!', 5.0, 2, 3, 2),
('Chất lượng giấy chưa tốt lắm.', 3.0, 4, 5, 4),
('Rất cảm động, đáng đọc.', 5.0, 6, 7, 6),
('Giao hàng nhanh, sách đẹp.', 5.0, 8, 9, 8),
('Đọc rất cuốn, nên mua nha.', 5.0, 10, 1, 10),
('Sách phù hợp với thiếu nhi.', 4.8, 1, 2, 1),
('Giá hơi đắt so với nội dung.', 2.5, 3, 4, 3),
('Khóc hết nước mắt vì truyện.', 5.0, 5, 6, 5),
('Gợi nhớ tuổi thơ mãnh liệt.', 4.5, 7, 8, 7),
('Rất thực tế và sâu sắc.', 4.5, 9, 10, 9);

INSERT INTO favorite_books (book_id, user_id) VALUES 
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10);

INSERT INTO cart_items (quantity, book_id, user_id) VALUES 
(1, 2, 1), (2, 3, 2), (1, 4, 3), (3, 5, 4), (1, 6, 5), (2, 7, 6), (1, 8, 7), (4, 9, 8), (1, 10, 9), (2, 1, 10);

INSERT INTO feedbacks (title, comment, is_read, user_id) VALUES
('Dịch vụ tốt', 'Giao hàng cực kỳ nhanh và cẩn thận.', false, 2),
('Thiếu sản phẩm', 'Tôi đặt 2 quyển nhưng chỉ nhận được 1.', true, 3),
('Lỗi ứng dụng', 'Thanh toán bằng thẻ hay bị lỗi.', false, 4),
('Góp ý', 'Mong nhà sách thêm tính năng Dark Mode trên app.', true, 5),
('Giao nhầm sách', 'Tôi nhận được sách không đúng với đơn hàng.', false, 6),
('Cảm ơn', 'Nhân viên tư vấn rất nhiệt tình.', true, 7),
('Thanh toán lỗi', 'Đã trừ tiền MoMo nhưng đơn hàng chưa thành công.', false, 8),
('Giao chậm', 'Chờ cả tuần mới nhận được sách.', true, 9),
('Đóng gói đẹp', 'Sách đến tay còn nguyên vẹn, không bị cong mép.', false, 10),
('Lỗi đăng nhập', 'Tôi không thể quên mật khẩu qua email được.', true, 1);
