package com.graphql.example.service;

import com.graphql.example.model.DeliveryPerson;
import com.graphql.example.model.FoodOrder;

import java.util.List;

public interface IFoodOrderService {
    FoodOrder findById(Long id);
    List<FoodOrder> findAll();
    void createFoodOrder(FoodOrder foodOrder);
    void deleteFoodOrder(Long id);
}
