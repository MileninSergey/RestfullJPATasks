package org.example.restfulljpatasks.controller;

import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.module.entity.Task;
import org.example.restfulljpatasks.repositoriy.TaskRepository;
import org.example.restfulljpatasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

   private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //localhost:8080/tasks/create
    @PostMapping("/create")
    public Task createTask (@RequestBody Task task) throws InvalidTaskDataTypeException {
        return taskService.createTask(task);
    }

    //localhost:8080/tasks/delete
    @DeleteMapping("/delete")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task.getId());
    }

    //localhost:8080/tasks/list
    @GetMapping ()
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    //localhost:8080/tasks/
    @PutMapping ()
    public Task putTask(@RequestBody Task task)  {
        return taskService.putTask(task);
    }

    //localhost:8080/tasks/
    @PatchMapping ()
    public Task patchTask(@RequestBody Task task)  {
        return taskService.patchTask(task);
    }

}
