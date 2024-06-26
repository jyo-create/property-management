package com.kumar.propertymanagement.controller;

import com.kumar.propertymanagement.model.UserDTO;
import com.kumar.propertymanagement.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO){
      UserDTO userDTO1 =  userService.register(userDTO);
      return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO){
        UserDTO login = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        return new ResponseEntity<UserDTO>(login,HttpStatus.OK);
    }
}
