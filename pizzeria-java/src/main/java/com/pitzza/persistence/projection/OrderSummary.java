package com.pitzza.persistence.projection;

import java.time.LocalDateTime;
/*Las proyecciones son para obtener datos de varias tablas sin tener que traer toda la entidad; son resultados personalizados*/
public interface OrderSummary {
  Integer getIdOrder();
  String getCustomerName();
  LocalDateTime getOrderDate();
  Double getOrderTotal();
  String getPizzaNames();
}
