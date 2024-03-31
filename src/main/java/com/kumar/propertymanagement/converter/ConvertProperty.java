package com.kumar.propertymanagement.converter;

import com.kumar.propertymanagement.entity.PropertyEntity;
import com.kumar.propertymanagement.model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class ConvertProperty {
    public PropertyEntity convertDtoToEntity(PropertyDTO propertyDTO){
        return PropertyEntity.builder()
                .title(propertyDTO.getTitle())
                .address(propertyDTO.getAddress())
                .price(propertyDTO.getPrice())
                .description(propertyDTO.getDescription())
                .build();
    }

    public PropertyDTO convertPropertyEntityToDto(PropertyEntity propertyEntity){
        return PropertyDTO.builder()
                .address(propertyEntity.getAddress())
                .title(propertyEntity.getTitle())
                .price(propertyEntity.getPrice())
                .description(propertyEntity.getDescription())
                .propertyId(propertyEntity.getPropertyId())
                .build();
    }
}
