package com.example.coffeeshopwebapplication.service;

import com.example.coffeeshopwebapplication.entity.Customer;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CoffeeShopCustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);
        CustomerUserDetails customerUserDetails=null;

        // we will check if the user is in the database or not
        if(customer == null) throw new UsernameNotFoundException("The User is not registered");
        else {
            customerUserDetails = new CustomerUserDetails();
            customerUserDetails.setCustomer(customer);
        }
        return customerUserDetails;



    }
}
