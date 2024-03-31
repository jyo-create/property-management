package com.kumar.propertymanagement.service;

import com.kumar.propertymanagement.model.PropertyDTO;
import com.kumar.propertymanagement.model.UserDTO;

import java.util.List;

public interface UserService {

 UserDTO register(UserDTO userDTO);
 UserDTO login(String email, String password);
}
