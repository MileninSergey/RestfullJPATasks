package org.example.restfulljpatasks.service;

import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl2 implements TaskService{

    @Override
    public Task createTask(TaskDTO taskDTO) throws InvalidTaskDataTypeException {
        return null;
    }

    @Override
    public List<Task> createTasks(List<TaskDTO> tasks) throws InvalidTaskDataTypeException {
        return List.of();
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Task putTask(Task task) {
        return null;
    }



    @Override
    public Page<Task> getTaskPaginated(Pageable pageable) {
        return null;
    }
}
