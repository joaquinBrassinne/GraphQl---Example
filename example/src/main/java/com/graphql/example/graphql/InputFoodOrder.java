package com.graphql.example.graphql;


import lombok.Data;

@Data
public class InputFoodOrder {
    private Long id;
    private String customerName;
    private String address;
    private Integer totalAmount;
    private String deliveryPersonId;
}
