package com.pitzza.web.controllers;

import com.pitzza.persistence.entity.CustomerEntity;
import com.pitzza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "/customer" )

public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController ( CustomerService customerService ) {
    this.customerService = customerService;
  }

  @GetMapping
   public ResponseEntity < List <CustomerEntity > > getAllCustomers (){
      return ResponseEntity.ok( this.customerService.getAllCustomers ());
   }

  @GetMapping ( "/phone/{customerPhone}")
  public ResponseEntity < CustomerEntity > getByPhone ( @PathVariable String customerPhone ){
    return ResponseEntity.ok ( this.customerService.getByPhone ( customerPhone ));
  }
}
