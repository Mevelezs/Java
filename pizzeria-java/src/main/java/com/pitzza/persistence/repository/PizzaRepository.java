package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.PizzaEntity;
import com.pitzza.service.dto.UpdatePizzaPriceDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

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

  /**
   *
   @Query (value =
   "UPDATE pizza " +
   "SET price = :newPrice " +
   "WHERE id_pizza = :idPizza", nativeQuery = true )
   @Midifying // sin este valor no se puedo modificar la db con @Queries
   void updatePrice ( @Param ( "idPizza" ) int idPizza, @Param ( "newPrice" ) double newPrice );
    *
    USING: Spring Expression Language
   */

  @Query (value =
              "UPDATE pizza " +
              "SET price = :#{#newPizzaPrice.newPrice} " +
              "WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true )
  @Modifying
  void updatePrice ( @Param ( "newPizzaPrice" ) UpdatePizzaPriceDTO newPizzaPrice );

}
