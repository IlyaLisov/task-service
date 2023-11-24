package com.example.userservice.web.controller;

import com.example.userservice.model.Task;
import com.example.userservice.service.TaskService;
import com.example.userservice.web.dto.TaskDto;
import com.example.userservice.web.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/user/{userId}")
    public List<TaskDto> getAllByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getAllByUserId(userId);
        return taskMapper.toDto(tasks);
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        task = taskService.create(task);
        return taskMapper.toDto(task);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

}
