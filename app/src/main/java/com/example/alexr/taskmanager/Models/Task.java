package com.example.alexr.taskmanager.Models;

public class Task {
    private int id;
    private String name;
    private boolean isComplete;
    private String notes;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean getIsComplete(){
        return isComplete;
    }

    public String getNotes(){
        return notes;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }
}
