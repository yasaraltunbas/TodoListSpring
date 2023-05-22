package com.example.todoapp.repository;

import com.example.todoapp.entity.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListMongoRepository extends JpaRepository<TodoListItem,Integer> {
}
