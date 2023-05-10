package com.assessment.datodoapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.datodoapp.models.Item;
import com.assessment.datodoapp.repositories.ItemRepo;

@RestController
@RequestMapping("api/items")
public class ItemController {
    private ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("")
    public List<Item> getAllItems() {
        return (List<Item>) itemRepo.findAll();
    }
}
