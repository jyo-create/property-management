package com.kumar.propertymanagement.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PropertyDTO {
    private Long propertyId;
    private String title;
    private String description;
    private Double price;
    private String address;
}
