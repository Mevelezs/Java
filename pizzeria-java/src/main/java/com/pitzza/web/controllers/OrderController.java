package com.pitzza.web.controllers;

import com.pitzza.persistence.entity.OrderEntity;
import com.pitzza.persistence.projection.OrderSummary;
import com.pitzza.service.OrderService;
import com.pitzza.service.dto.RandomOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/orders" )
public class OrderController {
  private final OrderService orderService;

  @Autowired
  public OrderController ( OrderService orderService ) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity < List < OrderEntity > > getAll (){
    return ResponseEntity.ok( this.orderService.getAll ());
  }


  @GetMapping ( "/{idOrder}" )
  public ResponseEntity < OrderEntity > getOrderById ( @PathVariable int idOrder ){
    if ( this.orderService.exist ( idOrder ) ){
      return ResponseEntity.ok (this.orderService.getById ( idOrder ));
    }
    return ResponseEntity.notFound ().build ();
  }

  @GetMapping ("/today")
  public  ResponseEntity < List < OrderEntity > > getTodayOrders (){
    return ResponseEntity.ok(this.orderService.getTodayOrders ());
  }

  @GetMapping ("/outside")
  public  ResponseEntity < List < OrderEntity > > getOutsideOrders (){
    return ResponseEntity.ok(this.orderService.getOutsideOrders ());
  }

  @GetMapping ("/customer/{idCustomer}")
  public ResponseEntity < List  <OrderEntity > > getCustomerOrders (@PathVariable String idCustomer ){
    return ResponseEntity.ok(this.orderService.getCustomerOrders ( idCustomer ));
  }

  @GetMapping ("/summary/{idOrder}")
  public ResponseEntity < OrderSummary > getSummary ( @PathVariable int idOrder) {
    return ResponseEntity.ok (this.orderService.getSummary ( idOrder ));
  }

  @PostMapping
  public ResponseEntity < OrderEntity > saveOrder ( @RequestBody OrderEntity order) {
    if ( order.getIdOrder () == null || !this.orderService.exist ( order.getIdOrder () ) ){
      return ResponseEntity.ok(this.orderService.save ( order ));
    }
    return ResponseEntity.badRequest ().build ();
  }

  @PutMapping
  public ResponseEntity < OrderEntity > updateOrder ( @RequestBody OrderEntity order ) {
    if( this.orderService.exist ( order.getIdOrder () ) && order.getIdOrder () != null ){
      return ResponseEntity.ok( this.orderService.save ( order ) );
    }
    return ResponseEntity.badRequest ().build ();
  }

  @DeleteMapping ( "/{idOrder}" )
  public ResponseEntity < String > delete ( @PathVariable int idOrder ){
    if( this.orderService.exist ( idOrder ) ){
      this.orderService.delete ( idOrder );
      return ResponseEntity.ok("Order Deleted");
    }
    return ResponseEntity.notFound ().build ();
  }

  /**
   *
   * @param dto : en la peticion hay que enviar el josn en el body {idCustomer: valor entero, methd : valor} tal cual como está, sacando el idCustomer de la db
   * @return
   */
  @PostMapping ("/random")
  public ResponseEntity < Boolean > randomOrder ( @RequestBody RandomOrderDTO dto ){
   return  ResponseEntity.ok (this.orderService.saveRandomOrder ( dto ));
  }
}
