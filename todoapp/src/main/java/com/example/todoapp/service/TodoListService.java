package com.example.todoapp.service;

import com.example.todoapp.entity.TodoListItem;
import com.example.todoapp.repository.ToDoListMongoRepository;
import com.example.todoapp.result.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    public ToDoListMongoRepository toDoListMongoRepository;

    public TodoListService(ToDoListMongoRepository toDoListMongoRepository) {
        this.toDoListMongoRepository = toDoListMongoRepository;
    }

    public DataResult<List<TodoListItem>> getAll() {

        try {
            return new SuccessDataResult<List<TodoListItem>>
                    (this.toDoListMongoRepository.findAll(),"Yapılacaklar Listesi Listelendi");
        }
        catch (Exception e){
            return new ErrorDataResult("Ürünler listenemedi.");
        }
    }

    public Result addToDo(TodoListItem todoListItem) {
        this.toDoListMongoRepository.save(todoListItem);
        return new SuccessResult("Yapılacaklar Listesine eklendi.");    }

    public Result updateToDo(TodoListItem newTodoListItem) {
        Optional<TodoListItem> todoListItem = toDoListMongoRepository.findById(newTodoListItem.getId());
        TodoListItem foundToDoList = todoListItem.get();
        foundToDoList.setDescription(newTodoListItem.getDescription());
        toDoListMongoRepository.save(foundToDoList);
        return new SuccessResult("Yapılacaklar Listesi Güncellendi");
    }

    public Result deleteToDo(int id) {
        Optional<TodoListItem> product = toDoListMongoRepository.findById(id);
        toDoListMongoRepository.deleteById(id);
        return new SuccessResult("Yapılacak iş kaldırıldı.");


    }
}
