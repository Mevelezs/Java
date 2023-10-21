package com.ecomerce.java.persistence.crud;

import com.ecomerce.java.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository < Producto, Integer > {

  // esta es la forma nativa
  // @Query ( value = "SELECT * FROM productos WHERE id_categoria = ? ORDER BY nombre ASC", nativeQuery = true);

  /**
   * usando Query methods
   *  @param idCategoria : se tiene que llamar igual que al la clase
   *  */
  List <Producto> findByIdCategoriaOrderByNombreAsc ( int idCategoria );

  Optional <List <Producto> > findByCantidadStockLessThanAndEstado (int cantidadStock, boolean estado );


}