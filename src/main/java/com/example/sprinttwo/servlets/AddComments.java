package com.example.sprinttwo.servlets;

import com.example.sprinttwo.db.DBManager;
import com.example.sprinttwo.model.Comment;
import com.example.sprinttwo.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/add-comment")
public class AddComments extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user != null){
            String commentText = request.getParameter("comment");
            Long newsId = Long.parseLong(request.getParameter("news_id"));
            Comment comment = new Comment(commentText, user.getId(), newsId);
            DBManager.addComment(comment);
            response.sendRedirect("/details?news_id=" + newsId);
        }else{
            response.sendRedirect("/login");
        }
    }
}