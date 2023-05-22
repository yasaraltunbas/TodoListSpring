package com.example.todoapp.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoListItem {

    @Id
    private int id;
    private String description;

    public TodoListItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public TodoListItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoListItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
