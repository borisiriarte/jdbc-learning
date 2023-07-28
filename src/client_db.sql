SHOW DATABASES;
USE jdbc_course;

SHOW TABLES;

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

CREATE TABLE orders(
    order_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    client_id INT UNSIGNED,
    order_date DATE,
    payment_method VARCHAR(50),
    discount FLOAT UNSIGNED,
    is_sent BOOLEAN,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

INSERT INTO  orders (order_date, client_id, payment_method, discount, is_sent) VALUE
    ('2020-01-01', 21, 'Contado', 0.08, false),
    ('2022-01-01', 1, 'Aplazado', 0.02, true),
    ('2021-01-02', 2, 'Contado', 0.04, false),
    ('2022-01-03', 3, 'Contado', 0.05, false),
    ('2020-01-04', 4, 'Contado', 0.02, true),
    ('2022-09-05', 5, 'Tarjeta', 0.01, false),
    ('2022-01-06', 6, 'Contado', 0.03, false),
    ('2022-12-07', 7, 'Contado', 0.06, true),
    ('2022-01-08', 8, 'Aplazado', 0.04, false),
    ('2022-01-09', 9, 'Tarjeta', 0.02, false),
    ('2022-11-10', 10, 'Tarjeta', 0.01, true),
    ('2021-01-11', 11, 'Aplazado', 0.03, true),
    ('2022-01-12', 12, 'Contado', 0.07, true),
    ('2021-10-13', 13, 'Contado', 0.06, true),
    ('2022-01-14', 14, 'Contado', 0.05, true),
    ('2022-09-15', 15, 'Aplazado', 0.04, false),
    ('2021-01-16', 16, 'Tarjeta', 0.07, false),
    ('2022-01-17', 17, 'Aplazado', 0.08, true),
    ('2022-07-18', 18, 'Aplazado', 0.02, false),
    ('2020-01-19', 19, 'Contado', 0.01, true),
    ('2022-01-20', 20, 'Contado', 0.09, false),
    ('2023-04-21', 21, 'Contado', 0.01, false),
    ('2022-01-22', 16, 'Contado', 0.02, true),
    ('2020-08-23', 4, 'Contado', 0.03, false),
    ('2022-04-24', 5, 'Contado', 0.04, false),
    ('2022-08-25', 16, 'Contado', 0.05, false),
    ('2022-03-26', 12, 'Contado', 0.06, false);


SELECT * FROM clients;
SELECT * FROM orders;
CREATE PROCEDURE show_clientS()
BEGIN
    SELECT * FROM clients WHERE town = 'Cali';
END;

CALL show_clientS()


