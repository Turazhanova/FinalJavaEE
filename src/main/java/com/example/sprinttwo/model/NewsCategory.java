package com.example.sprinttwo.model;

public class NewsCategory {
    private int id;
    private String name;

    public NewsCategory() {
    }

    public NewsCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
