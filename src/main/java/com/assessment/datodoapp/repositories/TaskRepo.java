package com.assessment.datodoapp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.assessment.datodoapp.models.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
