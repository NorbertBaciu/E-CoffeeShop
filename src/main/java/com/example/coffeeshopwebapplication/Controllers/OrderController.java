package com.example.coffeeshopwebapplication.Controllers;

import com.example.coffeeshopwebapplication.entity.CartPayment;
import com.example.coffeeshopwebapplication.entity.CustomerDetails;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCartPaymentRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCustomerDetailsRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopMyCartRepository;
import com.example.coffeeshopwebapplication.service.CoffeeShopMyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    private CoffeeShopMyCartRepository myCartRepository;

    @Autowired
    private CoffeeShopCustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private CoffeeShopMyCartService myCartService;

    @Autowired
   private CoffeeShopCartPaymentRepository cartPaymentRepository;



    // This Controller is used for Controlling the Order details and Payment Details....
    @GetMapping("/homePageAuthorized/OrderPage")
    public String getOrderPage(Model model){
        model.addAttribute("userDetails" , new CustomerDetails());
        model.addAttribute("cartPayment" , new CartPayment());

        return "OrderPage";
    }
    @PostMapping("/process-userdetails")
    public String saveUserDetails(@ModelAttribute("userDetails") CustomerDetails customerDetails){
        customerDetails.setCustomer(myCartService.getCurrentlyLoggedInCustomer());
        customerDetailsRepository.save(customerDetails);
        System.out.println("customerDetails");
        System.out.println("Check DB");

        return "redirect:/homePageAuthorized/OrderPage";
    }

    // we need to implement the post for saving the card details
    @PostMapping("/process-cardpayment")
    public String savePaymentCardDetails(@ModelAttribute("cartPayment") CartPayment cartPayment){
        cartPayment.setCustomer(myCartService.getCurrentlyLoggedInCustomer());
        cartPayment.setTotalSum(myCartRepository.getSum());

        cartPaymentRepository.save(cartPayment);
        System.out.println(cartPayment);
        System.out.println("Check DB...");
        return "redirect:/homePageAuthorized/OrderPage";
    }

}
