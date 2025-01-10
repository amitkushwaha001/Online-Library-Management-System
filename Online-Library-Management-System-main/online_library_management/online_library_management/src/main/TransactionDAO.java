package com.library.dao;

import com.library.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/OnlineLibraryManagement";
    private String jdbcUsername = "root"; // Your MySQL username
    private String jdbcPassword = "password"; // Your MySQL password

    private static final String INSERT_TRANSACTION_SQL = "INSERT INTO Transactions (bookID, memberID, borrowDate, returnDate) VALUES (?, ?, ?, ?)";
    private static final String SELECT_TRANSACTION_BY_ID = "SELECT * FROM Transactions WHERE transactionID = ?";
    private static final String SELECT_ALL_TRANSACTIONS = "SELECT * FROM Transactions";
    private static final String UPDATE_RETURN_DATE_SQL = "UPDATE Transactions SET returnDate = ? WHERE transactionID = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertTransaction(Transaction transaction) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION_SQL)) {
            preparedStatement.setInt(1, transaction.getBookID());
            preparedStatement.setInt(2, transaction.getMemberID());
            preparedStatement.setDate(3, Date.valueOf(transaction.getBorrowDate()));
            preparedStatement.setDate(4, null); // returnDate initially null
            preparedStatement.executeUpdate();
        }
    }

    public Transaction selectTransaction(int id) {
        Transaction transaction = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSACTION_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int bookID = rs.getInt("bookID");
                int memberID = rs.getInt("memberID");
                Date borrowDate = rs.getDate("borrowDate");
                Date returnDate = rs.getDate("returnDate");
                transaction = new Transaction(id, bookID, memberID, borrowDate.toLocalDate(),
                        returnDate != null ? returnDate.toLocalDate() : null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public List<Transaction> selectAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTIONS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("transactionID");
                int bookID = rs.getInt("bookID");
                int memberID = rs.getInt("memberID");
                Date borrowDate = rs.getDate("borrowDate");
                Date returnDate = rs.getDate("returnDate");
                transactions.add(new Transaction(id, bookID, memberID, borrowDate.toLocalDate(),
                        returnDate != null ? returnDate.toLocalDate() : null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public boolean updateReturnDate(int transactionID, LocalDate returnDate) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RETURN_DATE_SQL)) {
            statement.setDate(1, Date.valueOf(returnDate));
            statement.setInt(2, transactionID);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
public List<Transaction> getDueTransactions() {
    List<Transaction> dueTransactions = new ArrayList<>();
    String query = "SELECT * FROM Transactions WHERE returnDate IS NULL AND borrowDate < NOW() - INTERVAL 15 DAY";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("transactionID");
            int bookID = rs.getInt("bookID");
            int memberID = rs.getInt("memberID");
            Date borrowDate = rs.getDate("borrowDate");
            dueTransactions.add(new Transaction(id, bookID, memberID, borrowDate.toLocalDate(), null));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dueTransactions;
}
