package com.graphql.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    private String address;
    @Column(name = "total_amount")
    private Integer totalAmount;

    @ManyToOne(targetEntity = DeliveryPerson.class, fetch = FetchType.LAZY)
    private DeliveryPerson deliveryPerson;
}
