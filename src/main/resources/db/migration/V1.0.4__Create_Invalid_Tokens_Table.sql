CREATE TABLE invalid_tokens (
    id VARCHAR(255) PRIMARY KEY,
    expiry_time TIMESTAMPTZ NOT NULL
);

-- Dữ liệu mẫu cho bảng invalid_tokens
INSERT INTO invalid_tokens (id, expiry_time) VALUES
('4e28dfde-0db8-4ca3-bfa4-469b61d31cfc', NOW() + INTERVAL '1 day'),
('9b7b9f3e-5f3a-4228-a3f2-1a4869c3a3b2', NOW() + INTERVAL '12 hours');
