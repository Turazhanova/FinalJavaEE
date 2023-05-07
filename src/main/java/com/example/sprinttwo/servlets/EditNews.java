package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.News;
import com.example.sprinttwo.model.NewsCategory;
import com.example.sprinttwo.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-news")
public class EditNews extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currUser = (User)request.getSession().getAttribute("currentUser");
        if(currUser != null) {
            Long news_id = Long.parseLong(request.getParameter("id"));
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            News news = DBManager.getNews(news_id);
            NewsCategory newsCategory = DBManager.getCategory(category_id);
            if (news != null && newsCategory != null) {
                news.setTitle(title);
                news.setContent(content);
                news.setNewsCategory(category_id);
                DBManager.updateNews(news);
                response.sendRedirect("/details?news_id=" + news_id);
            } else {
                response.sendRedirect("/");
            }
        }else {
            response.sendRedirect("/");
        }
    }
}