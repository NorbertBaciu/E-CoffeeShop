package com.example.coffeeshopwebapplication.repository;

import com.example.coffeeshopwebapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeShopCustomerRepository extends JpaRepository<Customer,Integer> {

   Customer findByUsername(String username); // this method will be used to retrieve from the database customer with the
                                              // specific username
}
