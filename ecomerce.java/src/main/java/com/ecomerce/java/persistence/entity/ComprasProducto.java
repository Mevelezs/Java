package com.ecomerce.java.persistence.entity;

import javax.persistence.*;

@Entity
@Table ( name = "compras_productos" )
public class ComprasProducto {

  @EmbeddedId
  private ComprasProductoPK id;

  private Integer cantidac;
  private Double total;
  private Boolean estado;

  @ManyToOne
  @JoinColumn ( name = "id_producto", insertable = false, updatable = false)
  private Producto producto;

  @ManyToOne
  @JoinColumn ( name = "id_compra", insertable = false, updatable = false )
  private Compra compra;

  public ComprasProductoPK getId () {
    return id;
  }

  public void setId ( ComprasProductoPK id ) {
    this.id = id;
  }

  public Integer getCantidac () {
    return cantidac;
  }

  public void setCantidac ( Integer cantidac ) {
    this.cantidac = cantidac;
  }

  public Double getTotal () {
    return total;
  }

  public void setTotal ( Double total ) {
    this.total = total;
  }

  public Boolean getEstado () {
    return estado;
  }

  public void setEstado ( Boolean estado ) {
    this.estado = estado;
  }
}
