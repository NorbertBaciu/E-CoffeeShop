package com.example.coffeeshopwebapplication.Controllers;

import com.example.coffeeshopwebapplication.entity.CoffeeShopMyCartElement;
import com.example.coffeeshopwebapplication.entity.Customer;
import com.example.coffeeshopwebapplication.entity.Products;
import com.example.coffeeshopwebapplication.repository.CoffeeShopCustomerRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopMyCartRepository;
import com.example.coffeeshopwebapplication.repository.CoffeeShopProductRepository;
import com.example.coffeeshopwebapplication.service.CoffeeShopMyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MyCartController {


    @Autowired
    private CoffeeShopMyCartService myCartService;
    @Autowired
    private CoffeeShopMyCartRepository myCartRepository;

    @PostMapping("/process-machiatto")
    public String processMachiatto(){
       Products product;

        //retrieve machiatto from the Database
      product =   myCartService.getProductSelected(2);

      System.out.println(product);
        // after this we need to use the method to retrieve the current Authenticated User

       Customer  currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        System.out.println(currentCustomer);

        // after all this we need to save the data [current logged in user , selectedProduct , quantity(defualt 1) , and total_price=1)
        // in the order_items DB
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(10);

        myCartRepository.save(myCartElement);

      return "redirect:/homePageAuthorized";

        // after all this we need to save the data [current logged in user , selectedProduct , quantity(defualt 1) , and total_price=1)
        // in the order_items DB
    }
    @PostMapping("/process-espresso")
    public String addEspressoToMyCart(){
        Products product = myCartService.getProductSelected(1);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(6);

        myCartRepository.save(myCartElement);

        return "redirect:/homePageAuthorized";
    }
    @PostMapping("/process-latte")
    public String addCoffeeLatteToMyCart(){
        Products product = myCartService.getProductSelected(3);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(11);

        myCartRepository.save(myCartElement);

        return "redirect:/homePageAuthorized/CatalogPage2Authorized";
    }

    @PostMapping("/process-cappuccino")
    public String addCappuccinoToMyCart(){
        Products product = myCartService.getProductSelected(4);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(10);

        myCartRepository.save(myCartElement);

        return "redirect:/homePageAuthorized/CatalogPage2Authorized";
    }

    @PostMapping("/process-miel")
    public String addMielToMyCart(){
        Products product = myCartService.getProductSelected(5);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(14);

        myCartRepository.save(myCartElement);


        return "redirect:/homePageAuthorized/CatalogPage3Authorized";
    }

    @PostMapping("/process-conpanna")
    public String addConPannaToMyCart(){
        Products product = myCartService.getProductSelected(6);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(11);

        myCartRepository.save(myCartElement);
        return "redirect:/homePageAuthorized/CatalogPage3Authorized";
    }

    @PostMapping("/process-frappe")
    public String addFrappeToMyCart(){
        Products product = myCartService.getProductSelected(7);
        Customer currentCustomer = myCartService.getCurrentlyLoggedInCustomer();
        CoffeeShopMyCartElement myCartElement = new CoffeeShopMyCartElement();
        myCartElement.setCustomer(currentCustomer);
        myCartElement.setTheProduct( product);
        myCartElement.setNumberOfCoffees(1);
        myCartElement.setTotalPrice(17);

        myCartRepository.save(myCartElement);

        return "redirect:/homePageAuthorized/CatalogPage3Authorized";
    }

    // Lets Implement the Logic for the MyCart Table and for Processing Data in the MyCart Page
    @GetMapping("/homePageAuthorized/MyCartPage")
    public String showMyCartPage( @ModelAttribute("myCartProd") CoffeeShopMyCartElement myCart , Model model){
        List<CoffeeShopMyCartElement> listMyCartElements = myCartRepository.findAll();
        model.addAttribute("listMyCartElements" , listMyCartElements);
        System.out.println("The Total Price after adding is :" + myCartRepository.getSum());
        model.addAttribute("totalPrice" , myCartRepository.getSum());
        return "MyCartPage";

    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value="id") int id , Model model){
        myCartRepository.deleteById(id);
       System.out.println("The New Price after Deletion is :" + myCartRepository.getSum());
       model.addAttribute("totalPrice" , myCartRepository.getSum());


        return "redirect:/homePageAuthorized/MyCartPage";
    }

    @GetMapping("/process-update/{id}/{productId}")
    public String updateQuantity(@PathVariable(value="id") int id ,@PathVariable(value="productId") int productId,  @ModelAttribute("myCardProd") CoffeeShopMyCartElement myCart , Model model){


       System.out.println("The Selected Quantity is : " + myCart.getNumberOfCoffees());
   // int currentProductId =   myCart.getTheProduct().getProdId();

       // get the order id based on order selected
        CoffeeShopMyCartElement orderSelected = myCartRepository.findById(id);
        System.out.println("The Price of single cup is : " + orderSelected.getTotalPrice());
        int numberOfCoffees = myCart.getNumberOfCoffees();
        System.out.println("The Id of the order is :" + id);
        System.out.println("The Id of the Product Selected is :" + productId);

        if(productId == 1){
            myCartRepository.updateQuantity(id , myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 6;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id , myCart.getTotalPrice());

        }
        if(productId == 2){
            myCartRepository.updateQuantity(id , myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 10;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id , myCart.getTotalPrice());

        }
        if(productId==3) {
            myCartRepository.updateQuantity(id, myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 11;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id, myCart.getTotalPrice());
        }
        if(productId==4) {
            myCartRepository.updateQuantity(id, myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 10;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id, myCart.getTotalPrice());
        }
        if(productId==5) {
            myCartRepository.updateQuantity(id, myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 14;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id, myCart.getTotalPrice());
        }
        if(productId==7) {
            myCartRepository.updateQuantity(id, myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 17;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id, myCart.getTotalPrice());
        }

        if(productId == 6){
            myCartRepository.updateQuantity(id , myCart.getNumberOfCoffees());
            float price = myCart.getNumberOfCoffees() * 11;
            myCart.setTotalPrice(price);
            myCartRepository.updatePrice(id , myCart.getTotalPrice());

        }

        // now we need to display the total sum of all the Products that are selected :
         System.out.println("The Total Price you need to pay is: " + myCartRepository.getSum() + " RON");
        model.addAttribute("totalPrice" , myCartRepository.getSum());

        return "redirect:/homePageAuthorized/MyCartPage";
    }


}







