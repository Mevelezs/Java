package com.pitzza.persistence.repository;

import com.pitzza.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository < UserEntity, String > {
}
