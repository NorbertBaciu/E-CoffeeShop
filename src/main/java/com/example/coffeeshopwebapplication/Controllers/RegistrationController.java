package com.example.coffeeshopwebapplication.Controllers;

import com.example.coffeeshopwebapplication.entity.Customer;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCustomerRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopMyCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private CoffeeShopCustomerRepository theCustomerRepository;

    @Autowired
    private CoffeeShopMyCartRepository myCartRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/process-registration")
    public String processRegistration(@ModelAttribute("customer") Customer theCustomer){
        // We will use a passwordEncoder to store the password encrypted in the database

        String customerPassword = theCustomer.getPassword();
        String customerPasswordEncrypted = passwordEncoder.encode(customerPassword);
        theCustomer.setPassword(customerPasswordEncrypted);

        theCustomerRepository.save(theCustomer);

        System.out.println("User Registred...Check the DB");

        return "redirect:/homePage/loginPage";

    }

}
