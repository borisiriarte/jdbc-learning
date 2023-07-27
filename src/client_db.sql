SHOW DATABASES;
USE jdbc_course;

SHOW TABLES;
/*SELECT * FROM products_table;
DESCRIBE products_table;*/

CREATE DATABASE storaged_procedures;
USE storaged_procedures;
CREATE TABLE clients(
    client_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    town  VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    manager  VARCHAR(50) NOT NULL,
    history VARCHAR(50)
);

INSERT INTO  clients (company, address, town, phone, manager) VALUES
    ('Coca Cola', 'Calle 1', 'Cali', '12345678', 'Juan'),
    ('Pepsi', 'Calle 2', 'Bogota', '87654321', 'Pedro'),
    ('Fanta', 'Calle 3', 'Medellin', '23456789', 'Luis'),
    ('Sprite', 'Calle 4', 'Bucaramanga', '34567890', 'Maria'),
    ('Lays', 'Calle 5', 'Cartagena', '45678901', 'Ana'),
    ('Mars', 'Calle 6', 'Barranquilla', '56789012', 'Jose'),
    ('Snickers', 'Calle 7', 'Cali', '67890123', 'Luis'),
    ('Bounty', 'Calle 8', 'Barranquilla', '78901234', 'Maria'),
    ('Kinder', 'Calle 9', 'Bogota', '89012345', 'Jose'),
    ('Toyota', 'Calle 10', 'Medellin', '90123456', 'Maria'),
    ('Honda', 'Calle 11', 'Cartagena', '01234567', 'Jose'),
    ('Ford', 'Calle 12', 'Bucaramanga', '3456789', 'Maria'),
    ('Chevrolet', 'Calle 13', 'Cali', '456789', 'Jose'),
    ('Nissan', 'Calle 14', 'Barranquilla', '56789', 'Maria'),
    ('Tesla', 'Calle 15', 'Bogota', '6781234', 'Jose'),
    ('BMW', 'Calle 16', 'Medellin', '7891234', 'Maria'),
    ('Mercedes', 'Calle 17', 'Cartagena', '12341234', 'Jose'),
    ('Volvo', 'Calle 18', 'Bucaramanga', '9525312', 'Maria'),
    ('Audi', 'Calle 19', 'Cali', '04123412', 'Jose'),
    ('Volkswagen', 'Calle 20', 'Barranquilla', '51234321', 'Maria'),
    ('Jeep', 'Calle 21', 'Bogota', '21235123', 'Jose');

SELECT * FROM clients;
CREATE PROCEDURE show_clientS()
BEGIN
    SELECT * FROM clients WHERE town = 'Cali';
END;

CALL show_clientS();
