package com.pitzza.web.controllers;


import com.pitzza.persistence.entity.PizzaEntity;
import com.pitzza.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "/pizzas" )
public class PizzaController {

  private final PizzaService pizzaService;

  public PizzaController ( PizzaService pizzaService ) {
    this.pizzaService = pizzaService;
  }

  @GetMapping
  public ResponseEntity < List < PizzaEntity > > getAll(){
    return ResponseEntity.ok(this.pizzaService.getAll ());
  }

  @GetMapping ("/{idPizza}")
  public ResponseEntity < PizzaEntity > get( @PathVariable int idPizza){
    return ResponseEntity.ok(this.pizzaService.get ( idPizza ));
  }
}