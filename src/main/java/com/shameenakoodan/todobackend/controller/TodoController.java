package com.shameenakoodan.todobackend.controller;

import com.shameenakoodan.todobackend.model.Todo;
import com.shameenakoodan.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return (List<Todo>) todoRepository.findAll();
    }

    @PostMapping("/addtodo")
    public void saveTodo(@RequestBody  Todo todo){
        todoRepository.save(todo);
    }
}
