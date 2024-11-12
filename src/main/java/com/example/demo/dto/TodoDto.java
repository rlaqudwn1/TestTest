package com.example.demo.dto;

import com.example.demo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    Long id;
    String title;
    String description;

    public static TodoDto of(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .build();
    }

    public Todo toEntity() {
        return Todo.builder()
                .id(id)
                .title(title)
                .description(description)
                .build();
    }

}
