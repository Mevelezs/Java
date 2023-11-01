package com.pitzza.service;

import com.pitzza.persistence.entity.PizzaEntity;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;
import com.pitzza.persistence.repository.PizzaPagSortRepository;
import com.pitzza.persistence.repository.PizzaRepository;
import com.pitzza.service.dto.UpdatePizzaPriceDTO;
import com.pitzza.service.exception.EmailApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/* Sin Spring repository
@Service
public class PizzaService {
  private final JdbcTemplate jdbcTemplate;

  public PizzaService ( JdbcTemplate jdbcTemplate ) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List < PizzaEntity > getAll(){
    return this.jdbcTemplate.query ( "SELECT * FROM pizza", new BeanPropertyRowMapper<> ( PizzaEntity.class ) );
  }
} */

/** Usando los Repositorios */
@Service
public class PizzaService {
  private final PizzaRepository pizzaRepository;
  private final PizzaPagSortRepository pizzaPagSortRepository;

  @Autowired
  public PizzaService ( PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository ) {
    this.pizzaRepository = pizzaRepository;
    this.pizzaPagSortRepository = pizzaPagSortRepository;
  }

  public Page< PizzaEntity > getAll( int page, int elements){
    Pageable pageRequest = PageRequest.of ( page, elements);
    return this.pizzaPagSortRepository.findAll ( pageRequest );
  }

  public Page < PizzaEntity > getAvailable ( int page, int elements , String sortBy, String sortDirection ){
    Sort sort = Sort.by ( Sort.Direction.fromString ( sortDirection ), sortBy );
    Pageable pageRequest = PageRequest.of ( page, elements, sort);
    return this.pizzaPagSortRepository.findByAvailableTrue ( pageRequest );
  }

  public PizzaEntity getByName ( String name ){
    return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase ( name ).orElseThrow (() -> new RuntimeException ("La pizza no existe"));
  }

  public List < PizzaEntity > getWith ( String description ){
    return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase ( description );
  }

  public List < PizzaEntity > getWithout ( String description ){
    return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase ( description );
  }

  public List < PizzaEntity > getCheapest ( double price){
    return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc ( price );
  }

  public PizzaEntity get ( int idPizza ){
    return this.pizzaRepository.findById ( idPizza ).orElse ( null);
  }


  public boolean exists ( int idPizza ){
    return this.pizzaRepository.existsById ( idPizza );
  }

  public PizzaEntity save ( PizzaEntity pizza ){
    return this.pizzaRepository.save ( pizza );
  }

  public void delete ( int idPizza ){
    this.pizzaRepository.deleteById ( idPizza );
  }

  /**
   * @Transactional : serializa las transacciones usando el protocolo ACID;
                     y hace rollback si algo sale mal con la transaccion.
                     si le ponemos el neRollbackFor se salta la validacion de esta transaccion y
                     si hay una excepcion con esta no hace rollback, con el resto si lo hace
   * @param dto : recibe el objeto con el id de la pizza y el nuevo precio
   */
  @Transactional ( noRollbackFor = EmailApiException.class)
  public void updatePrice ( UpdatePizzaPriceDTO dto ){
     this.pizzaRepository.updatePrice ( dto );
     this.senEmail ();
  }

  /**
   * Método para lanzar una transacción que genera una excepcion
   */
  private void senEmail (){
    throw new EmailApiException ();
  }

}
