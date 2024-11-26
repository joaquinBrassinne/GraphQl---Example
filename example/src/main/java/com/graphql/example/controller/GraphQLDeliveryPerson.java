package com.graphql.example.controller;

import com.graphql.example.graphql.InputDeliveryPerson;
import com.graphql.example.model.DeliveryPerson;
import com.graphql.example.service.IDeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLDeliveryPerson {

    @Autowired
    private IDeliveryPersonService deliveryPersonService;

    @QueryMapping
    public DeliveryPerson findDeliveryPersonById(@Argument(name = "deliveryPersonId") String id){
        Long deliveryPerson = Long.parseLong(id);

        return this.deliveryPersonService.findById(deliveryPerson);
    }

    @QueryMapping
    public List<DeliveryPerson> findAllDeliveryPerson(){
        return this.deliveryPersonService.findAll();
    }

    @MutationMapping
    public String createDeliveryPerson(@Argument InputDeliveryPerson inputDeliveryPerson){
        DeliveryPerson deliveryPerson = DeliveryPerson.builder()
                .name(inputDeliveryPerson.getName())
                .lastName(inputDeliveryPerson.getLastName())
                .phoneNumber(inputDeliveryPerson.getPhoneNumber())
                .build();
        this.deliveryPersonService.createDeliveryPerson(deliveryPerson);

        return "Delivery Person created";
    }

    @MutationMapping
    public String deleteDeliveryPersonById(@Argument(name = "deliveryPersonId")  String id){
        Long deliveryPersonId = Long.parseLong(id);

        this.deliveryPersonService.deleteDeliveryPerson(deliveryPersonId);
        return "delivery Person deleted!";
    }
}
