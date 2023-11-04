package com.pitzza.web.controllers;


import com.pitzza.persistence.entity.PizzaEntity;
import com.pitzza.service.PizzaService;
import com.pitzza.service.dto.UpdatePizzaPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/pizzas" )
public class PizzaController {

  private final PizzaService pizzaService;

  @Autowired
  public PizzaController ( PizzaService pizzaService ) {
    this.pizzaService = pizzaService;
  }

  @GetMapping
  public ResponseEntity< Page< PizzaEntity > > getAll(
          @RequestParam (defaultValue = "0") int page,
          @RequestParam (defaultValue = "8") int elements){
    return ResponseEntity.ok(this.pizzaService.getAll ( page, elements));
  }

  @GetMapping ( "/available" )
  @CrossOrigin (origins = "http://127.0.0.1:5500")
  public ResponseEntity< Page< PizzaEntity > > getAvailable (
          @RequestParam (defaultValue = "0") int page,
          @RequestParam (defaultValue = "8") int elements,
          @RequestParam (defaultValue = "price") String sortBy,
          @RequestParam (defaultValue = "ASC") String sortDirection){
    return ResponseEntity.ok( this.pizzaService.getAvailable ( page, elements, sortBy, sortDirection ) );
  }

  @GetMapping ("/{idPizza}")
  public ResponseEntity < PizzaEntity > get( @PathVariable int idPizza){
    return ResponseEntity.ok(this.pizzaService.get ( idPizza ));
  }

  @GetMapping ("/name/{name}")
  public ResponseEntity < PizzaEntity > getByName (@PathVariable String name ){
    return ResponseEntity.ok (this.pizzaService.getByName ( name ));
  }

  @GetMapping ( "/with/{ingredient}" )
  public ResponseEntity <List < PizzaEntity > > getWith ( @PathVariable String ingredient ){
    return ResponseEntity.ok(this.pizzaService.getWith ( ingredient ));
  }

 @GetMapping ( "/cheapest/{price}" )
  public ResponseEntity <List < PizzaEntity > > getWith ( @PathVariable double price ){
    return ResponseEntity.ok(this.pizzaService.getCheapest ( price ));
  }

  @GetMapping ( "/without/{ingredient}" )
  public ResponseEntity <List < PizzaEntity > > getWithout ( @PathVariable String ingredient ){
    return ResponseEntity.ok(this.pizzaService.getWithout ( ingredient ));
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

  @PatchMapping ( "/price")
  public  ResponseEntity < String > updatePrice ( @RequestBody UpdatePizzaPriceDTO dto){
    if( this.pizzaService.exists ( dto.getPizzaId () )){
      this.pizzaService.updatePrice ( dto );
      return ResponseEntity.ok ("Price changed");
    }
    return ResponseEntity.notFound ().build ();
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
