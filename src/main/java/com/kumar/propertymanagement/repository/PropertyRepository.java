package com.kumar.propertymanagement.repository;

import com.kumar.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
