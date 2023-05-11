package com.assessment.datodoapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.datodoapp.models.Task;
import com.assessment.datodoapp.repositories.TaskRepo;

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
}
