package com.assessment.datodoapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.datodoapp.exception.FieldIncompleteException;
import com.assessment.datodoapp.exception.TaskNotFoundException;
import com.assessment.datodoapp.models.Task;
import com.assessment.datodoapp.repositories.TaskRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private TaskRepo taskRepo;

    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("")
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id) {
        if (!taskRepo.existsById(id)) {
            throw new TaskNotFoundException(id);
        } else {
            return taskRepo.findById(id);
        }
    }

    @PostMapping("")
    public Task createTask(@RequestBody Task task) {
        if (task.getTitle() == null) {
            throw new FieldIncompleteException();
        } else {
            Task newTask = new Task();
            newTask.setTitle(task.getTitle());
            newTask.setDescription(task.getDescription());
            return taskRepo.save(task);
        }
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskRepo.findById(id)
            .map(record -> {
                record.setTitle(task.getTitle());
                record.setDescription(task.getDescription());
                record.setCompleted(task.isCompleted());
                Task updated = taskRepo.save(record);
                return updated;
            }).orElseThrow(() -> new TaskNotFoundException(id));


    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        if (!taskRepo.existsById(id)) {
            throw new TaskNotFoundException(id);
        } else {
            taskRepo.deleteById(id);
        }
    }

    @DeleteMapping("")
    public void deleteAllTasks() {
        taskRepo.deleteAll();
    }

}
