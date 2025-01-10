package com.library.servlet;

import com.library.utils.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notifications")
public class NotificationServlet extends HttpServlet {
    private EmailSender emailSender;

    @Override
    public void init() {
        emailSender = new EmailSender();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");

        emailSender.sendEmail(recipient, subject, messageText);
        response.sendRedirect("notification-form.jsp?success=true");
    }
}
