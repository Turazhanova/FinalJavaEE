package com.example.sprinttwo.db;

import com.example.sprinttwo.model.Items;
import com.example.sprinttwo.model.Users;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

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

    public static ArrayList<Items> getAllItems(){

        ArrayList<Items> items = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                items.add(new Items(id, name, description, price));
            }
            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        return items;

    }
    public static boolean checkUser(String login, String password) {
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE users.username = '" + login + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                String ch_password = resultSet.getString("password");
                if (ch_password.equals(password)) {
                    return true;
                }
            }
            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }
        return false;
    }
    public static Users getUser(String username) {
        Users user = null;
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE users.username = '" + username + "'");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");
                user = new Users(id,username, password, full_name);
            }
            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }
        return user;
    }

}