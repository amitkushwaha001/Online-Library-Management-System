package com.user.dao;

import java.sql.*;
import com.user.model.user;

public class UserDAO {

    // Database connection details
    private String jdbcURL = "jdbc:mysql://localhost:3306/OnlineLibraryManagement";
    private String jdbcUsername = "root"; // Your MySQL username
    private String jdbcPassword = "password"; // Your MySQL password

    // SQL queries for CRUD operations
    private static final String SELECT_USER_BY_ID = "SELECT * FROM Members WHERE MemberID = ?";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM Members WHERE Email = ?";
    private static final String UPDATE_USER_PROFILE = "UPDATE Members SET Name = ?, Email = ?, PasswordHash = ?, Country = ? WHERE MemberID = ?";
    private static final String INSERT_USER = "INSERT INTO Members (Name, Email, MembershipID, PasswordHash, Country) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM Members WHERE MemberID = ?";

    public UserDAO() {}

    // Get a connection to the database
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Retrieve user by MemberID
    public user getUserById(int memberId) {
        user user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {

            preparedStatement.setInt(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String membershipId = resultSet.getString("MembershipID");
                String passwordHash = resultSet.getString("PasswordHash");
                String country = resultSet.getString("Country");

                user = new user(memberId, name, email, membershipId, passwordHash, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Retrieve user by Email
    public user getUserByEmail(String email) {
        user user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int memberId = resultSet.getInt("MemberID");
                String name = resultSet.getString("Name");
                String membershipId = resultSet.getString("MembershipID");
                String passwordHash = resultSet.getString("PasswordHash");
                String country = resultSet.getString("Country");

                user = new user(memberId, name, email, membershipId, passwordHash, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Update user profile
    public boolean updateUserProfile(user user) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PROFILE)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setInt(5, user.getMemberId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Insert new user into the database
    public boolean insertUser(user user) {
        boolean rowInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getMembershipId());
            preparedStatement.setString(4, user.getPasswordHash());
            preparedStatement.setString(5, user.getCountry());

            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    // Delete user by MemberID
    public boolean deleteUser(int memberId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setInt(1, memberId);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
