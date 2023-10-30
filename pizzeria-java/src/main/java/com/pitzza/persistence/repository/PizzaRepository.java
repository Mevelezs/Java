package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository < PizzaEntity, Integer > {
   List < PizzaEntity > findAllByAvailableTrueOrderByPrice();
 Optional < PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase ( String name );
   List < PizzaEntity > findAllByAvailableTrueAndDescriptionContainingIgnoreCase ( String description );
   List < PizzaEntity > findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase( String description);
   List < PizzaEntity > findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc( double price);
   int countByVeganTrue();
}
