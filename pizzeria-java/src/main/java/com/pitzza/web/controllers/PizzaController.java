package com.pitzza.web.controllers;


import com.pitzza.persistence.entity.PizzaEntity;
import com.pitzza.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  public ResponseEntity < PizzaEntity > add (@RequestBody PizzaEntity pizza ){
    if ( pizza.getIdPizza () == null || !this.pizzaService.exists ( pizza.getIdPizza () )){
      return ResponseEntity.ok( this.pizzaService.save ( pizza ) );
    }
    return ResponseEntity.badRequest ().build ();
  }


  @PutMapping
  public ResponseEntity < PizzaEntity > update ( @RequestBody PizzaEntity pizza){
    if ( pizza.getIdPizza () != null && this.pizzaService.exists ( pizza.getIdPizza () ) ){
      return ResponseEntity.ok( this.pizzaService.save ( pizza ) );
    }
    return ResponseEntity.badRequest ().build ();
  }

  @DeleteMapping ( "/{id}")
  public ResponseEntity < Void > delete (@PathVariable int id ){
    if ( this.pizzaService.exists ( id )){
      this.pizzaService.delete ( id );
      return ResponseEntity.ok ().build ();
    }

    return ResponseEntity.notFound ().build ();
  }
}
