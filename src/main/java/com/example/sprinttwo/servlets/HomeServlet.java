package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.Items;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> items = DBManager.getAllItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
