package com.library.servlet;

import com.library.dao.TransactionDAO;
import com.library.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
    private TransactionDAO transactionDAO;

    @Override
    public void init() {
        transactionDAO = new TransactionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Transaction> transactions = transactionDAO.selectAllTransactions();
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("transaction-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("borrow".equals(action)) {
            borrowBook(request, response);
        } else if ("return".equals(action)) {
            returnBook(request, response);
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        int memberID = Integer.parseInt(request.getParameter("memberID"));
        LocalDate borrowDate = LocalDate.now();

        Transaction transaction = new Transaction(bookID, memberID, borrowDate, null);
        try {
            transactionDAO.insertTransaction(transaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("transaction");
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int transactionID = Integer.parseInt(request.getParameter("transactionID"));
        LocalDate returnDate = LocalDate.now();

        try {
            transactionDAO.updateReturnDate(transactionID, returnDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("transaction");
    }
}
