package com.graphql.example.service.implementation;

import com.graphql.example.model.FoodOrder;
import com.graphql.example.repository.IFoodOrderRepository;
import com.graphql.example.service.IFoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodImplService implements IFoodOrderService {

    @Autowired
    private IFoodOrderRepository foodOrderRepository;


    @Override
    public FoodOrder findById(Long id) {
        return this.foodOrderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<FoodOrder> findAll() {
        return this.foodOrderRepository.findAll();
    }

    @Override
    public void createFoodOrder(FoodOrder foodOrder) {
        this.foodOrderRepository.save(foodOrder);
    }

    @Override
    public void deleteFoodOrder(Long id) {
        this.foodOrderRepository.deleteById(id);
    }
}


