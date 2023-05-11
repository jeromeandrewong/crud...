package com.assessment.datodoapp.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Task implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private boolean completed;

    //creating default constructor
    public Task() {
    }
    //for printing to console
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
                + "]";
    }
}
