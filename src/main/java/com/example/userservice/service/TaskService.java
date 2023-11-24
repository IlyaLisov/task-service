package com.example.userservice.service;

import com.example.userservice.model.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long userId);

    Task create(Task task);

    void delete(Long id);

}
