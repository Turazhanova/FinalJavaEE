package com.example.sprinttwo.servlets;

import com.example.sprinttwo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/profile")
public class UserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if(currentUser != null) {
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}