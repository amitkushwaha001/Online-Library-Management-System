package com.library.model;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private int bookID;
    private int memberID;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(int bookID, int memberID, LocalDate borrowDate, LocalDate returnDate) {
        this.bookID = bookID;
        this.memberID = memberID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Transaction(int id, int bookID, int memberID, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.bookID = bookID;
        this.memberID = memberID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getBookID() { return bookID; }
    public int getMemberID() { return memberID; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setId(int id) { this.id = id; }
    public void setBookID(int bookID) { this.bookID = bookID; }
    public void setMemberID(int memberID) { this.memberID = memberID; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
