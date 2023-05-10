package com.assessment.datodoapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.assessment.datodoapp.models.Item;
import com.assessment.datodoapp.repositories.ItemRepo;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public void run(String... args) throws Exception{
        List<Item> todos = (List<Item>) itemRepo.findAll();

        if (todos.size() == 0){
            Item todo1 = new Item();
            todo1.setDescription("test description 1");
            todo1.setTitle("test title 1");

            itemRepo.save(todo1);


        }
    }
}
