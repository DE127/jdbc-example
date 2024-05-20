-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS HumanResources;

-- Sử dụng cơ sở dữ liệu mới
USE HumanResources;

-- Tạo bảng Department
CREATE TABLE IF NOT EXISTS Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL UNIQUE
);

-- Tạo bảng Position
CREATE TABLE IF NOT EXISTS Positions (
    position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(255) NOT NULL UNIQUE
);

-- Tạo bảng Employee
CREATE TABLE IF NOT EXISTS Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    hire_date DATE NOT NULL,
    department_id INT,
    position_id INT,	
    FOREIGN KEY (department_id) REFERENCES Departments(department_id),
    FOREIGN KEY (position_id) REFERENCES Positions(position_id)
);

-- Tạo bảng Salary
CREATE TABLE IF NOT EXISTS Salary (
    salary_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    salary_amount DECIMAL(10, 2) NOT NULL CHECK (salary_amount >= 0),
    start_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);

-- Thêm dữ liệu vào bảng Department
INSERT INTO Departments (department_name) VALUES
    ('IT'),
    ('Finance'),
    ('HR');

-- Thêm dữ liệu vào bảng Position
INSERT INTO Positions (position_name) VALUES
    ('Software Developer'),
    ('Accountant'),
    ('HR Specialist');

-- Thêm dữ liệu vào bảng Employee
INSERT INTO Employees (first_name, last_name, date_of_birth, hire_date, department_id, position_id) VALUES
    ('John', 'Doe', '1990-05-15', '2020-01-10', 1, 1),
    ('Jane', 'Smith', '1985-08-22', '2019-03-05', 2, 2),
    ('Michael', 'Johnson', '1992-11-30', '2021-02-20', 3, 3);

-- Thêm dữ liệu vào bảng Salary
INSERT INTO Salary (employee_id, salary_amount, start_date) VALUES
    (1, 80000.00, '2020-01-10'),
    (2, 60000.00, '2019-03-05'),
    (3, 70000.00, '2021-02-20');
