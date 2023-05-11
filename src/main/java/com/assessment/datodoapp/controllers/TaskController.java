package com.assessment.datodoapp.controllers;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return taskRepo.findById(id);
    }

    @PostMapping("")
    public Task createTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        Optional<Task> taskData = taskRepo.findById(id);

        Task TaskToUpdate = new Task();
        if (taskData.isPresent()) {
            TaskToUpdate.setTitle(task.getTitle());
            TaskToUpdate.setDescription(task.getDescription());
            TaskToUpdate.setCompleted(task.isCompleted());
            return taskRepo.save(TaskToUpdate);
        } else {
            return TaskToUpdate;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        Optional<Task> taskToDelete = taskRepo.findById(id);
        if (taskToDelete.isPresent()) {
            taskRepo.deleteById(id);
        }
    }

}
