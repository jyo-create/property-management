package com.kumar.propertymanagement.service;

import com.kumar.propertymanagement.model.PropertyDTO;

import java.util.List;

public interface PropertyService {

     PropertyDTO save(PropertyDTO propertyDTO);

     List<PropertyDTO> getAll();

     PropertyDTO updateProperty(PropertyDTO propertyDTO,Long id);

     PropertyDTO updateEmail(PropertyDTO propertyDTO, Long id);

     void deleteProperty(Long id);
}
