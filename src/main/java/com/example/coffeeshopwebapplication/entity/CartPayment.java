package com.example.coffeeshopwebapplication.entity;

import javax.persistence.*;

@Entity
@Table(name="cart_info")
public class CartPayment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column(name="cartId")
    private int cartId;

    @Column(name="cart_number")
    private  String cartNumber;

    @Column(name="cart_name")
    private String cartName;

    @Column(name="expiry_date")
    private String expiryDate;

    @Column(name="cvv")
    private int cvv;

    @Column(name="total_sum")
    private int totalSum;

    @OneToOne
    private Customer customer;

    // Generate Constructor
     public CartPayment(){

     }
     public CartPayment( int cartId, String cartNumber , String cartName , String expiryDate , int cvv , int totalSum , Customer customer){
         this.cartId=cartId;
         this.cartNumber=cartNumber;
         this.cartName=cartName;
         this.expiryDate=expiryDate;
         this.cvv=cvv;
         this.totalSum=totalSum;
         this.customer=customer;
     }

     // generate getters and setters;


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    // generate the toString method for displaying in the Console the details


    @Override
    public String toString() {
        return "CartPayment{" +
                "cartId=" + cartId +
                ", cartNumber='" + cartNumber + '\'' +
                ", cartName='" + cartName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv=" + cvv +
                ", totalSum=" + totalSum +
                ", customer=" + customer +
                '}';
    }
}
