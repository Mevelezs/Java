package com.ecomerce.java.persistence.mapper;


import com.ecomerce.java.domain.PurchaseItem;
import com.ecomerce.java.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper ( componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

  @Mappings ( {
                      @Mapping ( source = "id.idProducto" , target = "productId"),
                      @Mapping ( source = "cantidad" , target = "quantity"),
                     // @Mapping ( source = "total" , target = "total"), cuando los nombre son iguales, no ha necesidad de especificar en el mapper
                      @Mapping ( source = "estado" , target = "active")
  } )
  PurchaseItem toPurchaseItem ( ComprasProducto producto);

  @InheritInverseConfiguration
  @Mappings ( {
                      @Mapping (target = "id.idCompra", ignore = true),
                      @Mapping (target = "producto", ignore = true),
                      @Mapping (target = "compra", ignore = true),
  } )
  ComprasProducto toComprasProducto ( PurchaseItem purchaseItem );
}
