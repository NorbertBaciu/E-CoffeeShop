package com.example.coffeeshopwebapplication.Controllers;

import com.example.coffeeshopwebapplication.entity.Customer;
import com.example.coffeeshopwebapplication.repository.CoffeeShopMyCartRepository;
import com.example.coffeeshopwebapplication.service.CoffeeShopMyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizedPagesController {

    @Autowired
    private CoffeeShopMyCartRepository myCartRepository;


    @PostMapping("/homePage/process-login")
    public String processLoginPage(@ModelAttribute("customer") Customer customer){
        return "redirect:/homePageAuthorized";
    }

    @GetMapping("/homePageAuthorized")
    public String showHomePageAuthorized(@ModelAttribute("customer") Customer customer){
        return "homePageAuthorized";
    }

    @GetMapping("/homePageAuthorized/logout")
    public String processLogout(){
        // When Clicking the logout Page We need to delete the products from the myCart and also Cart Details
        myCartRepository.deleteAll();
        return "redirect:/homePage";

    }

    // Here i will implement controllers for navigating in the HomePageAuthorized

    @GetMapping("/homePageAuthorized/ContactAuthorized")
    public String showContactPageAuthorized(){
        return "ContactAuthorized";
    }

    @GetMapping("/homePageAuthorized/CatalogPage2Authorized")
    public String showCatalogPage2Authorized(){
        return "CatalogPage2Authorized";
    }
    @GetMapping("/homePageAuthorized/CatalogPage3Authorized")
    public String showCatalogPage3Authorized(){
        return "CatalogPage3Authorized";
    }
    @GetMapping("/homePageAuthorized/CatalogPage4Authorized")
    public String showCatalogPage4Authorized(){
        return "CatalogPage4Authorized";
    }

}
