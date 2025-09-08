package com.example.Loans.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private Double loanAmount;

    private Float interestRate;

    private Integer tenureInMonths;

    private String loanStatus;

    private Long customerId;

    @Column(updatable = false)
    private LocalDateTime createdDt;

    @Column(insertable = false)
    private LocalDateTime lastUpdatedDt;

}
