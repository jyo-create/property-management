package com.kumar.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="PROPERTY")
public class PropertyEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long propertyId;
        @Column(name = "TITLE", nullable = false)
        private String title;
        private String description;

        private Double price;
        private String address;


}
