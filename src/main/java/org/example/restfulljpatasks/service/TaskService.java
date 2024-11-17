package org.example.restfulljpatasks.service;

import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.exceptions.TaskNotFoundException;
import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
     Task createTask(TaskDTO taskDTO) throws InvalidTaskDataTypeException;

     List<Task> createTasks(List<TaskDTO> tasks) throws InvalidTaskDataTypeException;

     void deleteTask(Long id);

     List<Task> findAll ();

     Task putTask(Task task);

     Task patchTask(Task task);

     Page<Task> getTaskPaginated (Pageable pageable);
}
