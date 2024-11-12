package com.example.demo.service;

import com.example.demo.dto.TodoDto;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TodoService {
    final TodoRepository repository;

    public TodoDto create(TodoDto dto) {
        Todo todo = dto.toEntity();
        Todo savedTodo = repository.save(todo);
        return TodoDto.of(savedTodo);
    }

    public TodoDto get(Long id) {
        return repository.findById(id).map(TodoDto::of)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<TodoDto> getList() {
        return repository.findAll().stream()
                .map(TodoDto::of)
                .toList();
    }
}
