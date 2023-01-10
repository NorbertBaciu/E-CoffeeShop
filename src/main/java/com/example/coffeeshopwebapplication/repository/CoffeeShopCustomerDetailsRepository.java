package com.example.coffeeshopwebapplication.repository;

import com.example.coffeeshopwebapplication.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeShopCustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
}
