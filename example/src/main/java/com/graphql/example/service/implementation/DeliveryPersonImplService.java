package com.graphql.example.service.implementation;

import com.graphql.example.model.DeliveryPerson;
import com.graphql.example.repository.IDeliveryPersonRepository;
import com.graphql.example.service.IDeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPersonImplService implements IDeliveryPersonService {

    @Autowired
    private IDeliveryPersonRepository deliveryPersonRepository;

    @Override
    public DeliveryPerson findById(Long id) {
        return this.deliveryPersonRepository.findById(id).orElseThrow();
    }

    @Override
    public List<DeliveryPerson> findAll() {
        return this.deliveryPersonRepository.findAll();
    }

    @Override
    public void createDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public void deleteDeliveryPerson(Long id) {
        this.deliveryPersonRepository.deleteById(id);
    }
}
