package org.example.restfulljpatasks.controller;

import jakarta.validation.Valid;

import org.example.restfulljpatasks.exceptions.InvalidTaskDataTypeException;
import org.example.restfulljpatasks.module.dto.TaskDTO;
import org.example.restfulljpatasks.module.entity.Task;
import org.example.restfulljpatasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")


public class TaskController {

    @Autowired
    @Qualifier("taskServiceImpl")
    private  TaskService taskService;

    @PostMapping("/create/bulk")
    public List<Task> createTasks(@Valid @RequestBody List<TaskDTO> taskDTOArray) throws InvalidTaskDataTypeException {
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
    @GetMapping()
    public Page<Task> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    )
    {
        return taskService.getTaskPaginated(PageRequest.of(page,size));
    }


    //localhost:8080/tasks/
    @PutMapping()
    public Task putTask(@RequestBody Task task) {
        return taskService.putTask(task);
    }


}
