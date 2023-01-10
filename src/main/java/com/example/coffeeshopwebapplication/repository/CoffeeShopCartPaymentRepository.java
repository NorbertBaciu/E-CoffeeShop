package com.example.coffeeshopwebapplication.repository;

import com.example.coffeeshopwebapplication.entity.CartPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeShopCartPaymentRepository extends JpaRepository<CartPayment, Integer> {
}
