package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository< CustomerEntity, String > {
  /**
   * USING JPQL
   *
   * @param phone: variable que se declara con los : en la consulta y luego se pasa al metodo
   * @return: el resultado de la consulta usando la entidad (CustomerEntity) y no la tabla directamente como los usan los queryMethods
   */
  @Query ( value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")
  CustomerEntity findByPhone ( @Param ( "phone" ) String phone );

  /**
   * USING NATIVES SQLs
   *
   * @return: el resultado de la consulta usando la tabla (customer) directamente
   */
  @Query ( value = "SELECT * FROM customer", nativeQuery = true)
  List < CustomerEntity > findAllCustomers ();
}

