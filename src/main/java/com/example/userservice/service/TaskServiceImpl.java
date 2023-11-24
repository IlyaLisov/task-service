package com.example.userservice.service;

import com.example.userservice.model.Task;
import com.example.userservice.model.exception.ResourceNotFoundException;
import com.example.userservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Task> getAllByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
