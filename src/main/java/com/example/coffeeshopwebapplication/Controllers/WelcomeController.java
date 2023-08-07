package com.example.coffeeshopwebapplication.Controllers;

import com.example.coffeeshopwebapplication.entity.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class WelcomeController {

    @RequestMapping("")
    public String showWelcomePage(){
        return "welcomePage.html";
    }
}

