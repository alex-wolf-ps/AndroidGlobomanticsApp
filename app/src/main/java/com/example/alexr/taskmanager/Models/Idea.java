package com.example.alexr.taskmanager.Models;

public class Idea {
    private int id;
    private String name;
    private String status;
    private String description;
    private String owner;

    // Gets
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getDescription(){
        return description;
    }

    public String getOwner(){
        return owner;
    }

    // Sets
    public void setId(int id){ this.id = id; }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }
}
