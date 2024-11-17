package org.example.restfulljpatasks.mapper;

import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity (TaskDTO taskDTO);
    TaskDTO toDto(Task task);
}

