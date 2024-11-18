-- SQL Schema for Online Library Management System

-- Table for managing books
CREATE DATABASE ONLINELIBRARY;
USE ONLINELIBRARY;
CREATE TABLE Books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    genre VARCHAR(100),
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for managing members
CREATE TABLE Members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    membership_id VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for managing transactions (borrow and return)
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    member_id INT,
    borrow_date DATE,
    return_date DATE,
    status ENUM('borrowed', 'returned') DEFAULT 'borrowed',
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (member_id) REFERENCES Members(member_id)
);

-- Table for managing notifications
CREATE TABLE Notifications (
    notification_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    message TEXT NOT NULL,
    notification_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (member_id) REFERENCES Members(member_id)
);

-- Table for managing borrowing history
CREATE TABLE BorrowingHistory (
    history_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    book_id INT,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    action_type ENUM('borrow', 'return') NOT NULL,
    FOREIGN KEY (member_id) REFERENCES Members(member_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- Table for storing inventory reports
CREATE TABLE InventoryReports (
    report_id INT PRIMARY KEY AUTO_INCREMENT,
    report_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    report_details TEXT
);

-- View for librarian dashboard
CREATE VIEW LibrarianDashboard AS
SELECT 
    Books.book_id, 
    Books.title, 
    Books.author, 
    Books.isbn, 
    Members.member_id, 
    Members.name AS member_name, 
    Transactions.transaction_id, 
    Transactions.borrow_date, 
    Transactions.return_date, 
    Transactions.status
FROM 
    Books
LEFT JOIN 
    Transactions ON Books.book_id = Transactions.book_id
LEFT JOIN 
    Members ON Transactions.member_id = Members.member_id;

-- View for member dashboard
CREATE VIEW MemberDashboard AS
SELECT 
    Members.member_id,
    Books.title,
    Transactions.borrow_date,
    Transactions.return_date,
    Transactions.status
FROM 
    Members
JOIN 
    Transactions ON Members.member_id = Transactions.member_id
JOIN 
    Books ON Transactions.book_id = Books.book_id;
