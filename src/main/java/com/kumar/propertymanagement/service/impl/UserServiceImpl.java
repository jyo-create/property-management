package com.kumar.propertymanagement.service.impl;

import com.kumar.propertymanagement.converter.ConvertUser;
import com.kumar.propertymanagement.entity.UserEntity;
import com.kumar.propertymanagement.model.UserDTO;
import com.kumar.propertymanagement.repository.UserRepository;
import com.kumar.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConvertUser convertUser;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = convertUser.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = convertUser.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
