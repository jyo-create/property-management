package com.kumar.propertymanagement.controller;

import com.kumar.propertymanagement.model.Calculator;
import com.kumar.propertymanagement.model.PropertyDTO;
import com.kumar.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/properties")
@RestController
public class PropertyController {

    @Value("${pms.dummy}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String saysHello(){
        return "Hellow user!";
    }

    @GetMapping("/add")
    public Double addNumbers(@RequestParam("a") Double num1, @RequestParam("b") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2,
            @RequestParam("num3") Double num3){
        return num1-num2-num3;
    }

    @PostMapping("/multiply")
    public ResponseEntity multiply(@RequestBody Calculator calculator){
        Double result = calculator.getNum1()*calculator.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/save")
    public ResponseEntity saveProperty(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO property =  propertyService.save(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(property,HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/get")
    public ResponseEntity getAllProperties(){
        System.out.println(dummy+"*********");
        List<PropertyDTO> all = propertyService.getAll();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(
                all,HttpStatus.CREATED
        );
        return responseEntity;

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateById(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){
        PropertyDTO propertyDTO1 = propertyService.updateProperty(propertyDTO, id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO1,HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/email/{id}")
    public ResponseEntity updateEmail(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){
        PropertyDTO propertyDTO1 = propertyService.updateEmail(propertyDTO, id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO1,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return new ResponseEntity("Entry deleted" ,HttpStatus.OK);

    }
}
