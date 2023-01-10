package com.example.coffeeshopwebapplication.Controllers;


import com.example.coffeeshopwebapplication.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoffeeShopController {



    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcomePage";
    }



    @GetMapping("/homePage")
    public String showHomePage(){
    return "homePage";}

    @GetMapping("/homePage/contactPage")
    public String showContactPage(){
        return "Contact";
    }

    @GetMapping("/homePage/loginPage")
    public String showLoginPage(@ModelAttribute("customer") Customer customer){


        return "LogInPage";
    }
    @GetMapping("/homePage/registerPage")
    public String showRegisterPage(Model model){
        model.addAttribute("customer",new Customer());
        return "RegisterPage.html";
    }
    @GetMapping("/homePage/catalogPage1")
    public String showCatalogPage1(){
        return "homePage";
    }
    @GetMapping("/homePage/catalogPage2")
    public String showCatalogPage2(){
        return "CatalogPage2";
    }
    @GetMapping("/homePage/catalogPage3")
    public String showCatalogPage3(){
        return "CatalogPage3";
    }

    @GetMapping("/homePage/catalogPage4")
    public String showCatalogPage4(){
        return "CatalogPage4";
    }




}
