package com.graphql.example.controller;

import com.graphql.example.graphql.InputFoodOrder;
import com.graphql.example.model.DeliveryPerson;
import com.graphql.example.model.FoodOrder;
import com.graphql.example.service.IDeliveryPersonService;
import com.graphql.example.service.IFoodOrderService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class GraphQLFoodOrder {

    @Autowired
    private IFoodOrderService iFoodOrderService;

    @Autowired
    private IDeliveryPersonService personService;

    @QueryMapping
    public FoodOrder findFoodOrderById(@Argument("foodOrderId") String id){
        Long foodOrder = Long.parseLong(id); //PARSEAMOS EL STRING A LONG

        return this.iFoodOrderService.findById(foodOrder);
    }

    @QueryMapping
    public List<FoodOrder> findAllFoodOrder(){
        return this.iFoodOrderService.findAll();
    }

    @MutationMapping
    public String createFoodOrder(@Argument InputFoodOrder inputFoodOrder){
        //TRAEMOS EL OBJETO DE DELIVERY PERSON PARA ASIGNARLO AL PEDIDO
        DeliveryPerson deliveryPerson = this.personService.findById(Long.parseLong(inputFoodOrder.getDeliveryPersonId()));

        if (deliveryPerson == null){
            throw new RuntimeException("Delivery person not found for ID: " + deliveryPerson.getId());
        }

        FoodOrder foodOrder = FoodOrder.builder()
                .customerName(inputFoodOrder.getCustomerName())
                .address(inputFoodOrder.getAddress())
                .totalAmount((inputFoodOrder.getTotalAmount()))
                .deliveryPerson(deliveryPerson)
                .build();
        this.iFoodOrderService.createFoodOrder(foodOrder);

        return "Food order created!";
    }

    @MutationMapping
    public String deleteFoodOrderById(@Argument("foodOrderId") String id){
        Long idFood = Long.parseLong(id); //PARSEAMOS A LONG

        this.iFoodOrderService.deleteFoodOrder(idFood);
        return "food order deleted!";
    }
}
