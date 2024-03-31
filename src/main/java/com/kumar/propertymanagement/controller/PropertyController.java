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
    public ResponseEntity<Double> multiply(@RequestBody Calculator calculator){
        Double result = calculator.getNum1()*calculator.getNum2();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO property =  propertyService.save(propertyDTO);
        return new ResponseEntity<>(property,HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        System.out.println(dummy+"*********");
        List<PropertyDTO> all = propertyService.getAll();
        return new ResponseEntity<>(
                all,HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PropertyDTO> updateById(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){
        PropertyDTO propertyDTO1 = propertyService.updateProperty(propertyDTO, id);
        return new ResponseEntity<>(propertyDTO1,HttpStatus.OK);
    }

    @PatchMapping("/email/{id}")
    public ResponseEntity<PropertyDTO> updateEmail(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){
        PropertyDTO propertyDTO1 = propertyService.updateEmail(propertyDTO, id);
        return new ResponseEntity<>(propertyDTO1,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return new ResponseEntity("Entry deleted" ,HttpStatus.OK);

    }
}
