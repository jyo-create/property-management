package com.kumar.propertymanagement.converter;

import com.kumar.propertymanagement.entity.UserEntity;
import com.kumar.propertymanagement.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class ConvertUser {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity  userEntity = UserEntity.builder()
                .ownerName(userDTO.getOwnerName())
                .ownerEmail(userDTO.getOwnerEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
        return userEntity;
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO = UserDTO.builder()
                .userId(userEntity.getUserId())
                .ownerName(userEntity.getOwnerName())
                .ownerEmail(userEntity.getOwnerEmail())
                //.password(userEntity.getPassword())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
        return  userDTO;
    }
}
