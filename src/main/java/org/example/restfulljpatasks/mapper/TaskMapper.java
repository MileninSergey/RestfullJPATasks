package org.example.restfulljpatasks.mapper;

import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity (TaskDTO taskDTO);
    TaskDTO toDto(Task task);
    List<Task> toEntityList (List<TaskDTO> list);
}

