package com.example.Customer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@ToString(exclude = "customer")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    private Long accountNo;

    private String ifscCode;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


}
