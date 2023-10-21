package com.ecomerce.java.domain.repository;

import com.ecomerce.java.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  List < Product > getAll();
  Optional < List < Product > > getByCategory ( String categoryId );
  Optional < List < Product > > getScareProducts ( int quantity );
  Optional < List < Product > > getProduct (int productId );
  Product save ( Product product );
  void delete ( int productId );
}
