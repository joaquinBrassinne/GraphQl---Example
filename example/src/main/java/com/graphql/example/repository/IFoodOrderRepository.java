package com.graphql.example.repository;

import com.graphql.example.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
