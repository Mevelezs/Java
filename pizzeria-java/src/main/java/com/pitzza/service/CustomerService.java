package com.pitzza.service;

import com.pitzza.persistence.entity.CustomerEntity;
import com.pitzza.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService ( CustomerRepository customerRepository ) {
    this.customerRepository = customerRepository;
  }

  @Secured( {"ROLE_ADMIN"} ) // asegura que solo el admin pueda accede a esta ruta
  public List < CustomerEntity > getAllCustomers (){
    return this.customerRepository.findAllCustomers ();
  }

  public CustomerEntity getByPhone ( String phone ){
    return this.customerRepository.findByPhone ( phone );
  }

}
