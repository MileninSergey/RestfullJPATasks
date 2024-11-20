package org.example.restfulljpatasks.service;

import lombok.AllArgsConstructor;
import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.exceptions.TaskNotFoundException;

import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.example.restfulljpatasks.mapper.TaskMapper;

import org.example.restfulljpatasks.repositoriy.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
     Task createTask(TaskDTO taskDTO) throws InvalidTaskDataTypeException;

     List<Task> createTasks(List<TaskDTO> tasks) throws InvalidTaskDataTypeException;

     void deleteTask(Long id);

     List<Task> findAll ();

     Task putTask(Task task);

     Page<Task> getTaskPaginated(Pageable pageable);
}
