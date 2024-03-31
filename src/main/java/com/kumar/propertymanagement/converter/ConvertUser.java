package com.kumar.propertymanagement.converter;

import com.kumar.propertymanagement.entity.UserEntity;
import com.kumar.propertymanagement.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class ConvertUser {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        return UserEntity.builder()
                .ownerName(userDTO.getOwnerName())
                .ownerEmail(userDTO.getOwnerEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        return UserDTO.builder()
                .userId(userEntity.getUserId())
                .ownerName(userEntity.getOwnerName())
                .ownerEmail(userEntity.getOwnerEmail())
                //.password(userEntity.getPassword())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
}
