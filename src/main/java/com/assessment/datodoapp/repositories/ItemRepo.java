package com.assessment.datodoapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.datodoapp.models.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {

}
