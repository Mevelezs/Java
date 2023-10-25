package com.ecomerce.java.persistence;

import com.ecomerce.java.domain.Product;
import com.ecomerce.java.domain.repository.ProductRepository;
import com.ecomerce.java.persistence.crud.ProductoCrudRepository;
import com.ecomerce.java.persistence.entity.Producto;
import com.ecomerce.java.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
  @Autowired
  private ProductoCrudRepository productoCrudRepository;
  @Autowired
  private ProductMapper mapper;

  @Override
  public List< Product > getAll (){
    List < Producto > productos = ( List< Producto > ) productoCrudRepository.findAll ();
    return mapper.toProduct ( productos );
  }

  @Override
  public Optional < List < Product > > getByCategory ( int categoryId ) {
    List< Producto >  productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc ( categoryId );
    return Optional.of ( mapper.toProduct ( productos ));
  }

  @Override
  public Optional < List < Product > > getScareProducts (int quantity){
    Optional < List < Producto > > productos = productoCrudRepository.findByCantidadStockLessThanAndEstado ( quantity, true );
    return productos.map( prod -> mapper.toProduct ( prod ) );
  }

  @Override
  public Optional < Product > getProductById (int productId){
    return productoCrudRepository.findById ( productId ).map ( producto -> mapper.toProduct ( producto ) );
  }

  public Product save( Product product ){
    Producto producto = mapper.toProducto ( product);
    return mapper.toProduct ( productoCrudRepository.save ( producto ) );
  }

  @Override
  public void delete (int productId ){
    productoCrudRepository.deleteById ( productId );
  }
}
