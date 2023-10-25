package com.ecomerce.java.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table ( name = "compras" )
public class Compra {
  @Id
  @GeneratedValue ( strategy = GenerationType.IDENTITY )
  @Column ( name = "id_compra" )
  private Integer id;

  @Column ( name = "id_cliente" )
  private String idClient;

  private LocalDateTime fecha;

  @Column ( name = "medio_pago" )
  private String medioPago;

  private String comentario;
  private String estado;

  @ManyToOne
  @JoinColumn ( name = "id_cliente", insertable = false, updatable = false )
  private Cliente cliente;

  @OneToMany ( mappedBy = "compra" , cascade = { CascadeType.ALL })
  private List <ComprasProducto> productos;

  public Integer getId () {
    return id;
  }

  public void setId ( Integer id ) {
    this.id = id;
  }

  public String getIdClient () {
    return idClient;
  }

  public void setIdClient ( String idClient ) {
    this.idClient = idClient;
  }

  public LocalDateTime getFecha () {
    return fecha;
  }

  public void setFecha ( LocalDateTime fecha ) {
    this.fecha = fecha;
  }

  public String getMedioPago () {
    return medioPago;
  }

  public void setMedioPago ( String medioPago ) {
    this.medioPago = medioPago;
  }

  public String getComentario () {
    return comentario;
  }

  public void setComentario ( String comentario ) {
    this.comentario = comentario;
  }

  public String getEstado () {
    return estado;
  }

  public void setEstado ( String estado ) {
    this.estado = estado;
  }

  public List< ComprasProducto > getProductos () {
    return productos;
  }

  public void setProductos ( List< ComprasProducto > productos ) {
    this.productos = productos;
  }

  public Cliente getCliente () {
    return cliente;
  }

  public void setCliente ( Cliente cliente ) {
    this.cliente = cliente;
  }

}
