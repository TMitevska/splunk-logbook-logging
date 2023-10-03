CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    quantity INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
);

-- Insert 20 rows in the users table
INSERT INTO users (id, first_name, last_name, email, phone_number)
VALUES
    (1, 'John', 'Doe', 'johndoe@example.com', '555-1234'),
    (2, 'Jane', 'Doe', 'janedoe@example.com', '555-5678'),
    (3, 'Bob', 'Smith', 'bobsmith@example.com', '555-9012'),
    (4, 'Alice', 'Johnson', 'alicejohnson@example.com', '555-3456'),
    (5, 'Tom', 'Jones', 'tomjones@example.com', '555-7890'),
    (6, 'Mary', 'Davis', 'marydavis@example.com', '555-2345'),
    (7, 'Mike', 'Wilson', 'mikewilson@example.com', '555-6789'),
    (8, 'Sarah', 'Garcia', 'sarahgarcia@example.com', '555-0123'),
    (9, 'David', 'Lee', 'davidlee@example.com', '555-4567'),
    (10, 'Linda', 'Smith', 'lindasmith@example.com', '555-8901');

-- Insert 20 rows in the product table
INSERT INTO product (id, name, description, price)
VALUES
    (1, 'iPhone 13', 'Apple iPhone 13 with A15 Bionic chip', 999),
    (2, 'Samsung Galaxy S21', 'Samsung Galaxy S21 with Exynos 2100 processor', 799),
    (3, 'Google Pixel 6', 'Google Pixel 6 with Tensor chip', 699),
    (4, 'OnePlus 9 Pro', 'OnePlus 9 Pro with Snapdragon 888 processor', 899),
    (5, 'Xiaomi Mi 11', 'Xiaomi Mi 11 with Snapdragon 888 processor', 749),
    (6, 'Sony Xperia 5 III', 'Sony Xperia 5 III with Snapdragon 888 processor', 999),
    (7, 'Huawei Mate 40 Pro', 'Huawei Mate 40 Pro with Kirin 9000 processor', 1199),
    (8, 'LG Wing 5G', 'LG Wing 5G with Snapdragon 765G processor', 699),
    (9, 'Motorola Moto G Stylus 5G', 'Motorola Moto G Stylus 5G with Snapdragon 480 processor', 399),
    (10, 'Asus ROG Phone 5', 'Asus ROG Phone 5 with Snapdragon 888 processor', 999);

-- Insert 20 rows in the cart table
INSERT INTO cart (id, user_id, product_id, date, quantity)
VALUES
    (1, 1, 1, CURRENT_TIMESTAMP, 1),
    (2, 1, 2, CURRENT_TIMESTAMP, 2),
    (3, 1, 3, CURRENT_TIMESTAMP, 1),
    (4, 2, 4, CURRENT_TIMESTAMP, 3),
    (5, 2, 5, CURRENT_TIMESTAMP, 1),
    (6, 2, 6, CURRENT_TIMESTAMP, 2);
