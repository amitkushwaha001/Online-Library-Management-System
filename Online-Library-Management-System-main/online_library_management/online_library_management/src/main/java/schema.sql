CREATE DATABASE OnlineLibraryManagement;

USE OnlineLibraryManagement;

-- Table for storing book information
CREATE TABLE Books (
    BookID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    ISBN VARCHAR(20) UNIQUE NOT NULL,
    Genre VARCHAR(100),
    AvailabilityStatus BOOLEAN DEFAULT TRUE
);

-- Table for storing member information
CREATE TABLE Members (
    MemberID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    MembershipID VARCHAR(50) UNIQUE NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL
);

-- Table for managing borrowing and return transactions
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    BookID INT NOT NULL,
    MemberID INT NOT NULL,
    BorrowDate DATE NOT NULL,
    ReturnDate DATE,
    Status ENUM('Borrowed', 'Returned') NOT NULL,
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

-- Table for managing notifications
CREATE TABLE Notifications (
    NotificationID INT PRIMARY KEY AUTO_INCREMENT,
    RecipientMemberID INT NOT NULL,
    NotificationDetails TEXT NOT NULL,
    NotificationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (RecipientMemberID) REFERENCES Members(MemberID)
);

-- Table for profile management
CREATE TABLE ProfileUpdates (
    ProfileUpdateID INT PRIMARY KEY AUTO_INCREMENT,
    MemberID INT NOT NULL,
    UpdateDetails TEXT NOT NULL,
    UpdateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

-- Table for book search history
CREATE TABLE SearchHistory (
    SearchID INT PRIMARY KEY AUTO_INCREMENT,
    MemberID INT NOT NULL,
    SearchCriteria VARCHAR(255),
    SearchDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

-- Table for inventory reports
CREATE TABLE InventoryReports (
    ReportID INT PRIMARY KEY AUTO_INCREMENT,
    ReportDetails TEXT NOT NULL,
    ReportDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for notification preferences
CREATE TABLE NotificationPreferences (
    PreferenceID INT PRIMARY KEY AUTO_INCREMENT,
    MemberID INT NOT NULL,
    PreferenceDetails TEXT NOT NULL,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);
