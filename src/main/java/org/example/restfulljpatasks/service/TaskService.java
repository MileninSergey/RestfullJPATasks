package org.example.restfulljpatasks.service;

import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.exceptions.TaskNotFoundException;
import org.example.restfulljpatasks.module.entity.Task;
import org.example.restfulljpatasks.repositoriy.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskRepository taskRepository;

    public Task createTask(Task task) throws InvalidTaskDataTypeException {
       if(!(task.getTitle() instanceof String)){
            throw new InvalidTaskDataTypeException("Поле 'title' должно быть строкой.");
        }

        if(!(task.getDescription() instanceof String)){
            throw new InvalidTaskDataTypeException("Поле 'Description' должно быть строкой.");
        }

        return taskRepository.save(task);
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
