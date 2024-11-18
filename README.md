# Online Library Management System

## Project Summary
The Online Library Management System aims to facilitate library staff in managing books, member accounts, and transactions while providing users with functionalities such as book search, borrowing/returning books, and viewing borrowing history.

## Table of Contents
1. [Project Description](#project-description)

2. [Features](#features)
   - [Librarian Features](#librarian-features)
   - [Member Features](#member-features)

3. [User Types](#user-types)

4. [Technology Stack](#technology-stack)


## Project Description
This project serves as a platform for managing a library's catalog, member accounts, and book transactions. Librarians can efficiently manage books, users, and transactions, while members can search for, borrow, and return books, view their borrowing history, and receive notifications about due dates and new arrivals.

## Features

### Librarian Features
1. **Book Management**
   - **Input**: Book details (title, author, ISBN, genre)
   - **Output**: Confirmation of successful addition, update, or deletion
   - **Functionality**: Add, edit, or delete books in the catalog

2. **Member Management**
   - **Input**: Member details (name, email, membership ID)
   - **Output**: Confirmation of successful member creation, update, or deletion
   - **Functionality**: Create, edit, or delete member accounts

3. **Transaction Management**
   - **Input**: Transaction details (book ID, member ID, borrow/return date)
   - **Output**: Confirmation of successful transaction
   - **Functionality**: Manage the borrowing and returning of books

4. **Notification Management**
   - **Input**: Notification details and recipient list
   - **Output**: Confirmation of successful notification dispatch
   - **Functionality**: Send notifications for due dates and new arrivals

5. **Inventory Reports**
   - **Input**: Inventory request
   - **Output**: Detailed report on inventory
   - **Functionality**: Generate reports on book inventory status and borrowing trends

### Member Features
1. **Book Search**
   - **Input**: Search criteria (title, author, genre)
   - **Output**: List of matching books
   - **Functionality**: Search for books in the catalog

2. **Borrow Book**
   - **Input**: Selected book ID
   - **Output**: Confirmation of successful borrowing
   - **Functionality**: Borrow books

3. **Return Book**
   - **Input**: Borrowed book ID
   - **Output**: Confirmation of successful return
   - **Functionality**: Return borrowed books

4. **Borrowing History**
   - **Input**: Member ID
   - **Output**: List of borrowed books and transaction details
   - **Functionality**: View borrowing history

5. **Profile Management**
   - **Input**: Profile details (name, email, password)
   - **Output**: Confirmation of successful profile update
   - **Functionality**: Update profile information

6. **Notification Alerts**
   - **Input**: Notification preferences
   - **Output**: Confirmation of notification settings
   - **Functionality**: Manage notification preferences

## User Types
1. **Librarian**: Manages the library catalog, member accounts, and oversees borrowing/return transactions.
2. **Member**: Searches for books, borrows and returns them, views their borrowing history, and manages profile and notifications.

## Technology Stack
- **Maven Project** using Eclipse IDEA 
- **Pom.xml**   dependancy 
- **Frontend**: HTML, CSS, JavaScript
- **Backend**:  JDK, Java (with suitable frameworks, JSP for server-side rendering)
- **Database**: Mysql, MongoDB, 
- **Notifications**: Email/SMS integration (optional)



