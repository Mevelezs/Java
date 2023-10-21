package com.ecomerce.java.persistence.entity;

import javax.persistence.*;

@Entity
@Table ( name = "productos")
public class Producto {
  @Id
  @GeneratedValue ( strategy = GenerationType.IDENTITY )
  @Column ( name = "id_product" )
  private Integer idProduct;

  private String name;
  @Column ( name = "id_categoria")

  private Integer idCategoria;
  @Column ( name = "codigo_barra" )

  private String codigoBarra;
  @Column ( name = "procio_venta" )

  private Double precioVenta;
  @Column ( name = "cantidad_stock" )

  private Integer cantidadStock;
  private Boolean estado;

  @ManyToOne
  @JoinColumn ( name = "id_categoria", insertable = false, updatable = false)
  private Categoria categoria;


  public Integer getIdProduct () {
    return idProduct;
  }

  public void setIdProduct ( Integer idProduct ) {
    this.idProduct = idProduct;
  }

  public String getName () {
    return name;
  }

  public void setName ( String name ) {
    this.name = name;
  }

  public Integer getIdCategoria () {
    return idCategoria;
  }

  public void setIdCategoria ( Integer idCategoria ) {
    this.idCategoria = idCategoria;
  }

  public String getCodigoBarra () {
    return codigoBarra;
  }

  public void setCodigoBarra ( String codigoBarra ) {
    this.codigoBarra = codigoBarra;
  }

  public Double getPrecioVenta () {
    return precioVenta;
  }

  public void setPrecioVenta ( Double precioVenta ) {
    this.precioVenta = precioVenta;
  }

  public Integer getCantidadStock () {
    return cantidadStock;
  }

  public void setCantidadStock ( Integer cantidadStock ) {
    this.cantidadStock = cantidadStock;
  }

  public Boolean getEstado () {
    return estado;
  }

  public void setEstado ( Boolean estado ) {
    this.estado = estado;
  }
}
