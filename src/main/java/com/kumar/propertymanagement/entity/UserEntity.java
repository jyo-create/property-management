package com.kumar.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="USER_DETAILS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String ownerName;

    @Column(name = "EMAIL", nullable = false)
    private String ownerEmail;

    private String phoneNumber;
    private String password;
}
