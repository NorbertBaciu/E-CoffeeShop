package com.example.coffeeshopwebapplication.service;

import com.example.coffeeshopwebapplication.entity.CoffeeShopMyCartElement;
import com.example.coffeeshopwebapplication.entity.Customer;
import com.example.coffeeshopwebapplication.entity.Products;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCartPaymentRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCustomerRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopMyCartRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;


import java.security.Principal;
import java.util.List;

@Service
public class CoffeeShopMyCartService {
   // In This Class I will Implement the methods for managing the data from the database
    @Autowired
    private CoffeeShopCustomerRepository customerRepository;

    @Autowired
    private CoffeeShopMyCartRepository myCartRepository;

    @Autowired
    private CoffeeShopProductRepository productRepository;

    @Autowired
    private CoffeeShopCartPaymentRepository cartPaymentRepository;

    // first we need to retrieve the coffe type from the Db based on the id
    public Products getProductSelected(int productId){

        return productRepository.findById(productId);
    }

    // secondly we need to retrieve the current authenticated user
   public Customer getCurrentlyLoggedInCustomer(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    Customer theCurrentCustomer = customerRepository.findByUsername(userDetails.getUsername());
   // Customer currentCustomer = new Customer();
   // currentCustomer.add(theCurrentCustomer);

    return theCurrentCustomer;
   }


}




