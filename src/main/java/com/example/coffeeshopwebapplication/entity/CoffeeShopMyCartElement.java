package com.example.coffeeshopwebapplication.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_items")
public class CoffeeShopMyCartElement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @ManyToOne()
    @JoinColumn(name="user_id_fk")
    private Customer customer ;

   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id_fk" )
    private Products theProduct;

    @Column(name="number_of_coffees")
    private int numberOfCoffees;     // this variable will contain the number of coffees each customer selected for ordering

    @Column(name="total_price")
    private float totalPrice;

  // Generate Default Constructor
    public CoffeeShopMyCartElement(){

    }
    // Generate Parametrized Constructor
    public CoffeeShopMyCartElement(int orderId , Customer customer  , Products theProduct , int numberOfCoffees , float totalPrice){
        this.orderId=orderId;
        this.customer=customer;

        this.theProduct = theProduct;
        this.numberOfCoffees = numberOfCoffees;
        this.totalPrice=totalPrice;
    }

    // Generate Getters and Setters


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Products getTheProduct() {
        return theProduct;
    }

    public void setTheProduct(Products theProduct) {
        this.theProduct = theProduct;
    }

    public int getNumberOfCoffees() {
        return numberOfCoffees;
    }

    public void setNumberOfCoffees(int numberOfCoffees) {
        this.numberOfCoffees = numberOfCoffees;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
