package com.kumar.propertymanagement.service.impl;

import com.kumar.propertymanagement.converter.ConvertProperty;
import com.kumar.propertymanagement.entity.PropertyEntity;
import com.kumar.propertymanagement.model.PropertyDTO;
import com.kumar.propertymanagement.repository.PropertyRepository;
import com.kumar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ConvertProperty convertProperty;
    @Override
    public PropertyDTO save(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = convertProperty.convertDtoToEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        propertyDTO = convertProperty.convertPropertyEntityToDto(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAll() {
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) propertyRepository.findAll();
        for(PropertyEntity pe:propertyEntityList){
            PropertyDTO propertyDTO = convertProperty.convertPropertyEntityToDto(pe);
            propertyDTOList.add(propertyDTO);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
        PropertyDTO propertyDTO1 = null;
        Optional<PropertyEntity> byId = propertyRepository.findById(id);
        if(byId.isPresent()){
            PropertyEntity propertyEntity = byId.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setDescription(propertyDTO.getDescription());

            propertyRepository.save(propertyEntity);
            propertyDTO1 = convertProperty.convertPropertyEntityToDto(propertyEntity);
        }
        return propertyDTO1;
    }

    @Override
    public PropertyDTO updateEmail(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> byId = propertyRepository.findById(id);
        PropertyDTO propertyDTO1 = null;
        if(byId.isPresent()){
            PropertyEntity propertyEntity = byId.get();
            propertyRepository.save(propertyEntity);
            propertyDTO1 = convertProperty.convertPropertyEntityToDto(propertyEntity);
        }
        return propertyDTO1;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

}
