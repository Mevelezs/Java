package com.ecomerce.java.persistence.mapper;

import com.ecomerce.java.domain.Purchase;
import com.ecomerce.java.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper ( componentModel = "spring", uses = { PurchaseItemMapper.class})
public interface PurchaseMapper {
  @Mappings ( {
                      @Mapping ( source = "id", target = "purchaseId"),
                      @Mapping ( source = "idClient", target = "clientId"),
                      @Mapping ( source = "fecha", target = "date"),
                      @Mapping ( source = "medioPago", target = "paymentMethod"),
                      @Mapping ( source = "comentario", target = "comment"),
                      @Mapping ( source = "estado", target = "state"),
                      @Mapping ( source = "productos", target = "item"),
  } )
  Purchase toPurchase ( Compra compra );
  List < Purchase > toPurchases ( List <Compra> compra );

  @InheritInverseConfiguration
  @Mapping ( target = "cliente", ignore = true )
  Compra toCompra ( Purchase purchase );

}
