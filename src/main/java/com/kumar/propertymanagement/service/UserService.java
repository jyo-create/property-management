package com.kumar.propertymanagement.service;

import com.kumar.propertymanagement.model.UserDTO;


public interface UserService {

 UserDTO register(UserDTO userDTO);
 UserDTO login(String email, String password);
}
