package com.ecomerce.java.persistence.mapper;

import com.ecomerce.java.domain.Category;
import com.ecomerce.java.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper ( componentModel = "spring" )
public interface CategoryMapper {
// se mapea la clase Categoria y se pasan los valores a category
  @Mappings ( {
              @Mapping ( source = "idCategoria", target = "categoryId" ),
              @Mapping ( source = "descripcion", target = "category" ),
              @Mapping ( source = "estado", target = "active" ),
  } )
  Category toCategory ( Categoria categoria );

// para hacer la operacion contraria ignorando el atributo que no está
  @InheritInverseConfiguration
  @Mapping ( target = "productos", ignore = true )
  Categoria toCategoria ( Category category );
}
