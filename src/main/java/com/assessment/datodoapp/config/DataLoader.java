package com.assessment.datodoapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assessment.datodoapp.models.Task;
import com.assessment.datodoapp.repositories.TaskRepo;


@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public void run(String... args) throws Exception{
        List<Task> todos = (List<Task>) taskRepo.findAll();

        if (todos.size() == 0){
            Task task = new Task();
            task.setDescription("test description 1");
            task.setTitle("test title 1");

            taskRepo.save(task);


        }
    }
}
