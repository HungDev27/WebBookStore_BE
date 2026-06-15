CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255),
    dob DATE,
    gender VARCHAR(50),
    avatar VARCHAR(255),
    phone VARCHAR(50),
    status VARCHAR(50),
    hash_active VARCHAR(255),
    billing_address VARCHAR(255),
    shipping_address VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE user_roles (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    author VARCHAR(255),
    description TEXT,
    list_price DECIMAL(10,2),
    sell_price DECIMAL(10,2),
    quantity INT,
    avg_rating DOUBLE PRECISION,
    sold_quantity INT,
    discount_percent INT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE book_genre (
    book_id INT,
    genre_id INT,
    PRIMARY KEY (book_id, genre_id),
    CONSTRAINT fk_book_genre_book FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT fk_book_genre_genre FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE images (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    is_icon BOOLEAN,
    url_image VARCHAR(255),
    data_image TEXT,
    book_id INT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_images_book FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE payments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    fee_payment DECIMAL(10,2),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE deliveries (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    fee_delivery DECIMAL(10,2),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    delivery_address VARCHAR(255),
    phone VARCHAR(50),
    full_name VARCHAR(255),
    total_price_product DECIMAL(10,2),
    fee_delivery DECIMAL(10,2),
    fee_payment DECIMAL(10,2),
    total_price DECIMAL(10,2),
    status VARCHAR(50),
    note VARCHAR(255),
    user_id INT NOT NULL,
    payment_id INT,
    delivery_id INT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_orders_payment FOREIGN KEY (payment_id) REFERENCES payments(id),
    CONSTRAINT fk_orders_delivery FOREIGN KEY (delivery_id) REFERENCES deliveries(id)
);

CREATE TABLE order_details (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    is_review BOOLEAN NOT NULL,
    book_id INT NOT NULL,
    order_id INT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_order_details_book FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT fk_order_details_order FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    content VARCHAR(255),
    rating_point REAL,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    order_detail_id INT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_reviews_book FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT fk_reviews_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_reviews_order_detail FOREIGN KEY (order_detail_id) REFERENCES order_details(id)
);

CREATE TABLE favorite_books (
    id SERIAL PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_favorite_books_book FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT fk_favorite_books_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cart_items (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_cart_items_book FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT fk_cart_items_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE feedbacks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    comment VARCHAR(255),
    is_read BOOLEAN NOT NULL,
    user_id INT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_feedbacks_user FOREIGN KEY (user_id) REFERENCES users(id)
);
