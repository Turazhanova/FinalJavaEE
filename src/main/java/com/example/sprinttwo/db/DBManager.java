package com.example.sprinttwo.db;

import com.example.sprinttwo.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Connection connection;

    static{

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "password");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    public static News getNews(Long id) {
        News news = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT n.id, n.post_date, n.category_id, n.title, n.content FROM news n " +
                        "JOIN news_categories nc ON n.category_id = nc.id " +
                        "WHERE n.id = ?"))
        {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                news = new News(resultSet.getLong(1),resultSet.getTimestamp(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addNews(News news) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO news (category_id, post_date, title, content) VALUES (?, NOW(), ?, ?)")) {
            statement.setInt(1, news.getNewsCategory());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateNews(News news) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE news SET " +
                        "category_id = ?, " +
                        "title = ?, " +
                        "content = ? WHERE id = ?")){
            statement.setInt(1, news.getNewsCategory());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            statement.setLong(4, news.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeNews(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM news WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserId(Long id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(resultSet.getLong("id"), resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("full_name"), resultSet.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User getUser(String email) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(resultSet.getLong("id"), resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("full_name"), resultSet.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user) {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users(email,password,full_name,role_id) VALUES (?,?,?,?)")) {
            insertStatement.setString(1, user.getEmail());
            insertStatement.setString(2, user.getPassword());
            insertStatement.setString(3, user.getFullName());
            insertStatement.setInt(4, user.getRole_id());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET email = ?, password = ?, full_name = ?, role_id = ? WHERE id = ?")){
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRole_id());
            statement.setLong(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static NewsCategory getCategory(int id) {
        NewsCategory newsCategory = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                newsCategory = new NewsCategory(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsCategory;
    }
    public static List<NewsCategory> getCategories() {
        List<NewsCategory> newsCategoryArrayList = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories ")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NewsCategory newsCategory = new NewsCategory(resultSet.getInt("id"), resultSet.getString("name"));
                newsCategoryArrayList.add(newsCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsCategoryArrayList;
    }
    public static List<Comment> getComments(Long newsID){
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.post_date, c.comment, c.user_id, u.full_name, c.news_id FROM comments c " +
                            "JOIN users u ON c.user_id = u.id " +
                            "WHERE c.news_id = ? "
            );
            statement.setLong(1,newsID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Comment comment = new Comment(resultSet.getLong("id"), resultSet.getString("comment"),resultSet.getTimestamp("post_date"),resultSet.getLong("news_id") ,resultSet.getLong("user_id") ) ;
                comments.add(comment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return comments;
    }
    public static void addComment(Comment comment){
        try (
                PreparedStatement statement = connection.prepareStatement("INSERT INTO comments (post_date, comment, user_id, news_id) VALUES (NOW(),?,?,?)")) {
            statement.setString(1,comment.getComment());
            statement.setLong(2,comment.getId());
            statement.setLong(3,comment.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}