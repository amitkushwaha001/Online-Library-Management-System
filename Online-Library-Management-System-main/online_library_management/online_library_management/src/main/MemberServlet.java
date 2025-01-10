package com.library.servlet;

import com.library.dao.UserDAO;
import com.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/members")
public class MemberServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteMember(request, response);
                break;
            default:
                listMembers(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "insert";
        switch (action) {
            case "insert":
                insertMember(request, response);
                break;
            case "update":
                updateMember(request, response);
                break;
        }
    }

    private void listMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> members = userDAO.getAllMembers();
        request.setAttribute("memberList", members);
        request.getRequestDispatcher("member-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User member = userDAO.getUserById(id);
        request.setAttribute("member", member);
        request.getRequestDispatcher("member-form.jsp").forward(request, response);
    }

    private void insertMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String membershipId = request.getParameter("membershipId");
        String password = request.getParameter("password");
        String country = request.getParameter("country");

        User newMember = new User(name, email, membershipId, password, country);
        userDAO.insertUser(newMember);
        response.sendRedirect("members");
    }

    private void updateMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String membershipId = request.getParameter("membershipId");
        String password = request.getParameter("password");
        String country = request.getParameter("country");

        User updatedMember = new User(id, name, email, membershipId, password, country);
        userDAO.updateUserProfile(updatedMember);
        response.sendRedirect("members");
    }

    private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("members");
    }
}
