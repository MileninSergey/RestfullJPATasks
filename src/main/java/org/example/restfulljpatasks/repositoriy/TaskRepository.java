package org.example.restfulljpatasks.repositoriy;

import org.example.restfulljpatasks.module.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long> {
    //Task createTask(Task task);

    //void deleteTask(Long id);

    //List<Task> getAllTasks ();

    //Task updateTask(@RequestBody Long id, @RequestBody Task task);

    //Task putTask(Task task);

    Page<Task> findAll (Pageable pageable);

    List<Task> findAll ();

}
