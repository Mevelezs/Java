package com.pitzza.service;

import com.pitzza.persistence.entity.PizzaEntity;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;
import com.pitzza.persistence.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/* Sin Spring repository
@Service
public class PizzaService {
  private final JdbcTemplate jdbcTemplate;

  public PizzaService ( JdbcTemplate jdbcTemplate ) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List < PizzaEntity > getAll(){
    return this.jdbcTemplate.query ( "SELECT * FROM pizza", new BeanPropertyRowMapper<> ( PizzaEntity.class ) );
  }
} */

/** Usando los Repositorios */
@Service
public class PizzaService {
  private final PizzaRepository pizzaRepository;

  public PizzaService ( PizzaRepository pizzaRepository ) {
    this.pizzaRepository = pizzaRepository;

  }

  public List < PizzaEntity > getAll(){
    return this.pizzaRepository.findAll ();
  }

  public PizzaEntity get ( int idPizza ){
    return this.pizzaRepository.findById ( idPizza ).orElse ( null);
  }
}
