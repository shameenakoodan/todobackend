package com.shameenakoodan.todobackend.repository;

import com.shameenakoodan.todobackend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    Todo findTodoById(Long id);
}