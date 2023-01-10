package com.example.coffeeshopwebapplication.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="product_id")
    private int prodId;

    @Column(name="coffee_type")
    private String coffeeType;


    @Column(name="coffee_price")
    private float coffee_price;

    // Generate Default Constructor
    public Products(){

    }

    // Generate Parametrized Constructor
    public Products(String coffeeType  , float coffee_price  ){
        this.coffeeType=coffeeType;

        this.coffee_price=coffee_price;

    }

    // Generate Setters and Getters


    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }


    public float getCoffee_price() {
        return coffee_price;
    }

    public void setCoffee_price(float coffee_price) {
        this.coffee_price = coffee_price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + prodId +
                ", coffeeType='" + coffeeType + '\'' +
                ", coffee_price=" + coffee_price +
                '}';
    }
}

