package com.pitzza.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass // anotacion para superclase que puede ser heredada por otras
public class AuditableEntity {

  @Column ( name = "created_date" )
  @CreatedDate // crea la fecha
  private LocalDateTime createdDate;

  @Column ( name = "modified_date" )
  @LastModifiedDate // crea la fecha de modificación
  private LocalDateTime modifiedDate;

}
