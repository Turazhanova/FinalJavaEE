package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.Comment;
import com.example.sprinttwo.model.News;
import com.example.sprinttwo.model.NewsCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("news_id"));
        News news = DBManager.getNews(id);
        List<NewsCategory> categories = DBManager.getCategories();
        List<Comment> comments = DBManager.getComments(id);
        request.setAttribute("news",news);
        request.setAttribute("categories",categories);
        request.setAttribute("comments",comments);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }
}