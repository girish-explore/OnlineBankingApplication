package com.microservices.registration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private Long id;
    @Column(nullable = false)
    private Long balance;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,length = 6)
    private Long otp;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;
}
