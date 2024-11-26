package com.graphql.example.repository;

import com.graphql.example.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
}
