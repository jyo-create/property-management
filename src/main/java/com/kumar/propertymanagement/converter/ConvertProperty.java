package com.kumar.propertymanagement.converter;

import com.kumar.propertymanagement.entity.PropertyEntity;
import com.kumar.propertymanagement.model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class ConvertProperty {
    public PropertyEntity convertDtoToEntity(PropertyDTO propertyDTO){
        PropertyEntity propertyEntity = PropertyEntity.builder()
                .title(propertyDTO.getTitle())
                .address(propertyDTO.getAddress())
                .price(propertyDTO.getPrice())
                .description(propertyDTO.getDescription())
                .build();
        return propertyEntity;
    }

    public PropertyDTO convertPropertyEntityToDto(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO= PropertyDTO.builder()
                .address(propertyEntity.getAddress())
                .title(propertyEntity.getTitle())
                .price(propertyEntity.getPrice())
                .description(propertyEntity.getDescription())
                .propertyId(propertyEntity.getPropertyId())
                .build();
        return propertyDTO;
    }
}
