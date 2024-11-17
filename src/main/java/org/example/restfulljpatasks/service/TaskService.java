package org.example.restfulljpatasks.service;

import lombok.AllArgsConstructor;
import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.exceptions.TaskNotFoundException;
import org.example.restfulljpatasks.mapper.TaskMapper;
import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.example.restfulljpatasks.repositoriy.TaskRepository;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskMapper taskMapper;
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO taskDTO) throws InvalidTaskDataTypeException {
        Task task = taskMapper.toEntity(taskDTO);

        return taskRepository.save(task);
    }

    public List<Task> createTasks(TaskDTO[] taskDTOArray) throws InvalidTaskDataTypeException {
        // Преобразуем массив DTO в список сущностей Task
        List<Task> tasks = Arrays.stream(taskDTOArray)
                .map(taskMapper::toEntity)
                .collect(Collectors.toList());

        // Сохраняем все задачи в базе
        return taskRepository.saveAll(tasks);
    }

    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Нет такой задачи с id: "+ id));

        taskRepository.deleteById(id);
    }

    public List<Task> findAll () {
        List<Task> tasks = taskRepository.findAll();

        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("Нет ни одной записи в базе данных.");
        }

        return tasks;
    }

    public Task putTask(Task task) {

        Task existingTask = taskRepository.findById(task.getId())
                                            .orElseThrow(() -> new TaskNotFoundException("Нет такой задачи с id: "));

        // Обновляем поля существующей задачи новыми данными
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCreateDate(task.getCreateDate());
        existingTask.setImplementTime(task.getImplementTime());

        return taskRepository.save(task);
    }

    public Task patchTask(Task task) {
        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new TaskNotFoundException("Нет такой задачи с id: "));

        // Обновляем поля существующей задачи новыми данными
        if (task.getTitle()!=null) {
            existingTask.setTitle(task.getTitle());
        }
        if (task.getDescription()!=null) {
            existingTask.setDescription(task.getDescription());
        }
        if (task.getCreateDate()!=null) {
            existingTask.setCreateDate(task.getCreateDate());
        }
        if (task.getImplementTime()!=null) {
        existingTask.setImplementTime(task.getImplementTime());
        }

        return taskRepository.save(task);
    }
}
