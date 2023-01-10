package com.example.coffeeshopwebapplication.repository;

import com.example.coffeeshopwebapplication.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeShopProductRepository extends JpaRepository<Products, Integer> {

 Products findById(int productId);

}
