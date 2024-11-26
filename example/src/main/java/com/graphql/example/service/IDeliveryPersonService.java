package com.graphql.example.service;

import com.graphql.example.model.DeliveryPerson;

import java.util.List;

public interface IDeliveryPersonService {
    DeliveryPerson findById(Long id);
    List<DeliveryPerson> findAll();
    void createDeliveryPerson(DeliveryPerson deliveryPerson);
    void deleteDeliveryPerson(Long id);
}
