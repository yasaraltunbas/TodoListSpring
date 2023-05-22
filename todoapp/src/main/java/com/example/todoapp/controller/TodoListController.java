package com.example.todoapp.controller;

import com.example.todoapp.entity.TodoListItem;
import com.example.todoapp.result.DataResult;
import com.example.todoapp.result.Result;
import com.example.todoapp.service.TodoListService;

import io.swagger.annotations.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class TodoListController {

    @Autowired
    TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/todo")
    public DataResult<List <TodoListItem>> getAllTodo(){

        return this.todoListService.getAll();

    }

    @PostMapping("/todo")
    public Result addToDo(@RequestBody TodoListItem todoListItem){

     return   this.todoListService.addToDo(todoListItem);
    }
    @PutMapping("/todo/{updateToDoById}")
    public Result updateToDo(@RequestBody TodoListItem newTodoListItem)

    {
        return this.todoListService.updateToDo(newTodoListItem);
    }

    @DeleteMapping("/todo/{deleteToDoById}")

    public Result deleteTodoById(int id) throws Exception {
        return this.todoListService.deleteToDo(id);
    }
}
