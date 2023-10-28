package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository < PizzaEntity, Integer > {

}
