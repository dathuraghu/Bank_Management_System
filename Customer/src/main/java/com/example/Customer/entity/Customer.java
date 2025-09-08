package com.example.Customer.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String email;

    private String phoneNo;

    @OneToOne(mappedBy = "customer")
    private Accounts accounts;

    private String metaStatus;
}
