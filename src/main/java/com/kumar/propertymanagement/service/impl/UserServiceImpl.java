package com.kumar.propertymanagement.service.impl;

import com.kumar.propertymanagement.converter.ConvertUser;
import com.kumar.propertymanagement.entity.UserEntity;
import com.kumar.propertymanagement.exception.BusinessException;
import com.kumar.propertymanagement.exception.ErrorModel;
import com.kumar.propertymanagement.model.UserDTO;
import com.kumar.propertymanagement.repository.UserRepository;
import com.kumar.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConvertUser convertUser;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = convertUser.convertDTOtoEntity(userDTO);
        Optional<UserEntity> byOwnerEmail = userRepository.findByOwnerEmail(userEntity.getOwnerEmail());
        if(!byOwnerEmail.isPresent()){
            userEntity = userRepository.save(userEntity);
            userDTO = convertUser.convertEntitytoDTO(userEntity);
        }else{
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel("USER_EXIST","User already exists");
            errors.add(errorModel);
            throw new BusinessException(errors);
        }

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent()){
            userDTO = convertUser.convertEntitytoDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel("INVALID_LOGIN","Incorrect username or password");
            errors.add(errorModel);
            throw new BusinessException(errors);
        }
        return userDTO;
    }
}
