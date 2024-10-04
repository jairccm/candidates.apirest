-- Script para crear la tabla 'candidates'

CREATE TABLE candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    card_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    gender CHAR(1) NOT NULL CHECK (gender IN ('M', 'F', 'O')),
    availability_date DATE NOT NULL,
    date_of_birth DATE NOT NULL,
    expected_salary DOUBLE NOT NULL,
    note TEXT NOT NULL,
    pre_selected BOOLEAN NOT NULL
);

-- Insertar datos de prueba iniciales
INSERT INTO candidates (card_id, name, last_name, email, phone_number, gender, availability_date, date_of_birth, expected_salary, note, pre_selected) VALUES
('ID12345', 'John', 'Doe', 'john.doe@example.com', '555-1234', 'M', '2024-01-15', '1990-05-20', 60000, 'Note about John', true),
('ID12346', 'Jane', 'Smith', 'jane.smith@example.com', '555-5678', 'F', '2024-01-20', '1988-09-12', 65000, 'Note about Jane', false),
('ID12347', 'Alan', 'Brown', 'alan.brown@example.com', '555-9101', 'M', '2024-02-01', '1992-03-05', 58000, 'Note about Alan', true),
('ID12348', 'Sara', 'Johnson', 'sara.johnson@example.com', '555-1122', 'F', '2024-03-10', '1995-07-23', 63000, 'Note about Sara', false),
('ID12349', 'Michael', 'White', 'michael.white@example.com', '555-3344', 'O', '2024-04-05', '1993-11-11', 70000, 'Note about Michael', true);
