package com.shameenakoodan.todobackend.controller;

import com.shameenakoodan.todobackend.model.Todo;
import com.shameenakoodan.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        System.out.println(todo.getIsActive());
        todoRepository.save(todo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodoStatus(@PathVariable Long id, @RequestBody Todo request) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (!todoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Todo todo = todoOptional.get();
        todo.setIsActive(request.getIsActive()); // Set the isActive status from the request

        todoRepository.save(todo);

        return ResponseEntity.ok().build();
    }
}