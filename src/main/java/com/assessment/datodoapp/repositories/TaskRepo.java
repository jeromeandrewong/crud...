package com.assessment.datodoapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.datodoapp.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

}
