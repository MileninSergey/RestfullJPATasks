package org.example.restfulljpatasks.controller;

import jakarta.validation.Valid;
import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.module.dto.TaskDTO;
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

    @PostMapping("/create/bulk")
    public List<Task> createTasks(@Valid @RequestBody TaskDTO[] taskDTOArray) throws InvalidTaskDataTypeException {
        return taskService.createTasks(taskDTOArray);
    }

    //localhost:8080/tasks/create
    @PostMapping("/create")
    public Task createTask (@Valid @RequestBody TaskDTO taskDTO) throws InvalidTaskDataTypeException {
        return taskService.createTask(taskDTO);
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
