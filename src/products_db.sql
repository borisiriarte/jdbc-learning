USE jdbc_course;

SHOW TABLES;
SELECT * FROM products_table;
DESCRIBE products_table;

CREATE PROCEDURE update_Products_Price(IN price_art INT, IN art_name VARCHAR(50))
    BEGIN
        UPDATE products_table SET price = price_art WHERE name = art_name;
    END;
