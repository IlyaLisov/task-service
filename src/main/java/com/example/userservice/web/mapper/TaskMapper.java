package com.example.userservice.web.mapper;

import com.example.userservice.model.Task;
import com.example.userservice.web.dto.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto dto);

    List<Task> toEntity(List<TaskDto> dtos);

}
