-- 1. Bổ sung mã đơn hàng định dạng chuỗi (VD: BKS12345) vào bảng orders
ALTER TABLE orders ADD COLUMN order_code VARCHAR(100) UNIQUE;

