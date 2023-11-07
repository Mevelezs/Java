package com.pitzza.persistence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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

  @Column ( name = "created_by" )
  @CreatedBy
  private  String createdBy;

  @Column ( name = "modified_by" )
  @LastModifiedBy
  private  String modifiedBy;
}
