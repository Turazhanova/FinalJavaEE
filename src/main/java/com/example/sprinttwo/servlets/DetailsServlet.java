package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/login")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (DBManager.checkUser(username, password)) {
            request.setAttribute("user", DBManager.getUser(username));
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        } else{
            request.setAttribute("text", "WRONG LOGIN OR PASSWORD!");
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        }


    }
}