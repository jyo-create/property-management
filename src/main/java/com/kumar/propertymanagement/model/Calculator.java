package com.kumar.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Calculator {
    @JsonProperty("alpha")
    private Double num1;
    private  Double num2;
}
