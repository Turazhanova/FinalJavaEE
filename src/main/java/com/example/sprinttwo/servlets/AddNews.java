package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.News;
import com.example.sprinttwo.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-news")
public class AddNews extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currUser = (User) request.getSession().getAttribute("currentUser");
        if (currUser != null) {
            int category_id = Integer.parseInt(request.getParameter("news_category_id"));
            String title = request.getParameter("news_title");
            String content = request.getParameter("news_content");
            News news = new News(category_id, title, content);
            DBManager.addNews(news);
        }
        response.sendRedirect("/home");
    }
}
