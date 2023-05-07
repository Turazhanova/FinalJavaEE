package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("full_name");
        User user = DBManager.getUser(email);
        if(user == null){
            User newUser = new User(email, fullName, password, 2);
            DBManager.addUser(newUser);
            response.sendRedirect("/register?cool");
        }else{
            response.sendRedirect("/register?Error");
        }
    }
}