package com.ecomerce.java.persistence.mapper;

import com.ecomerce.java.domain.Product;
import com.ecomerce.java.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper ( componentModel = "spring", uses = { CategoryMapper.class }) // el uses es porque ya category tiene su propio Mapper
public interface ProductMapper {
  @Mappings ( {
                      @Mapping ( source = "idProducto", target = "productId" ),
                      @Mapping ( source = "nombre", target = "name" ),
                      @Mapping ( source = "idCategoria", target = "categoryId" ),
                      @Mapping ( source = "precioVenta", target = "price" ),
                      @Mapping ( source = "cantidadStock", target = "stock" ),
                      @Mapping ( source = "estado", target = "activate" ),
                      @Mapping ( source = "categoria", target = "category" ),
  } )
  Product toProduct ( Producto producto );
  List < Product > toProduct ( List < Producto > productos );

  @InheritInverseConfiguration
  @Mapping ( target = "codigoBarra", ignore = true )
  Producto toProducto ( Product product );
}
