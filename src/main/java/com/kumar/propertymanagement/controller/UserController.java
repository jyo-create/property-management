package com.kumar.propertymanagement.controller;

import com.kumar.propertymanagement.model.UserDTO;
import com.kumar.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity register(@RequestBody UserDTO userDTO){
      UserDTO userDTO1 =  userService.register(userDTO);
      ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
      return responseEntity;
    }
}
