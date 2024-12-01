package com.user.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.user.dao.UserDAO;
import com.user.model.User;
import com.user.util.DbUtil;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO(DbUtil.getConnection());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("register")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(name, email, password);

            if (userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("register.jsp?error=Registration Failed");
            }
        } else if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDAO.loginUser(email, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid Login");
            }
        }
    }
}