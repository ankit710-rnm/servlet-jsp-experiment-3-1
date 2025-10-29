CREATE DATABASE college_portal;
USE college_portal;

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);
INSERT INTO users VALUES ('ankit', '12345'), ('admin', 'admin');

CREATE TABLE employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Salary DECIMAL(10,2)
);
INSERT INTO employee VALUES (1, 'Rahul', 50000), (2, 'Neha', 55000), (3, 'Ankit', 60000);

CREATE TABLE attendance (
    StudentID INT,
    Date DATE,
    Status VARCHAR(10)
);
