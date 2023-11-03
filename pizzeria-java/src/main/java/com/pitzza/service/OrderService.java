package com.pitzza.service;

import com.pitzza.persistence.entity.OrderEntity;
import com.pitzza.persistence.projection.OrderSummary;
import com.pitzza.persistence.repository.OrderRepository;
import com.pitzza.service.dto.RandomOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
  final private OrderRepository orderRepository;

  final private String DELIVERY = "D";
  final private String CARRYOUT = "C";
  final private String ON_SITE = "S";

  @Autowired
  public OrderService ( OrderRepository orderRepository ) {
    this.orderRepository = orderRepository;
  }

  public List < OrderEntity >  getAll(){
    return this. orderRepository.findAll ();
  }

  public List < OrderEntity > getTodayOrders (){
    LocalDateTime today = LocalDate.now ().atTime ( 0, 0 );
    return this.orderRepository.findAllByDateAfter ( today );
  }

  public List < OrderEntity > getOutsideOrders (){
    List < String > methods = Arrays.asList (CARRYOUT, DELIVERY);
    return this.orderRepository.findAllByMethodIn ( methods );
  }

  public OrderEntity getById ( int idOrder ){
    return this.orderRepository.findById ( idOrder ).orElse ( null );
  }

  public List < OrderEntity > getCustomerOrders ( String idCustomer ){
    return this.orderRepository.findCustomerOrders ( idCustomer );
  }

  public OrderSummary getSummary( int idOrder ){
    return this.orderRepository.findSummary ( idOrder );
  }
  public OrderEntity save ( OrderEntity orderEntity ) {
    return this.orderRepository.save ( orderEntity );
  }

  public void delete ( int idOrder ) {
    this.orderRepository.deleteById ( idOrder );
  }

  public boolean exist ( int idOrder ) {
    return this.orderRepository.existsById ( idOrder );
  }

  @Transactional
  public  boolean saveRandomOrder ( RandomOrderDTO randomOrderDTO ){
    return this.orderRepository.saveRandomOrder ( randomOrderDTO.getIdCustomer (), randomOrderDTO.getMethod ()  );
  }
}

