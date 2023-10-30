package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository < OrderEntity, Integer > {
  List < OrderEntity > findAllByDateAfter ( LocalDateTime date );
  List < OrderEntity > findAllByMethodIn ( List <String> methods);
}
