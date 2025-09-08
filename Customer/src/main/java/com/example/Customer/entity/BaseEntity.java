package com.example.Customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdDt;

    @Column(insertable = false)
    private LocalDateTime lastUpdatedDt;
}
