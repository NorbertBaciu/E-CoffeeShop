package com.example.coffeeshopwebapplication.entity;

import org.apache.catalina.User;

import javax.persistence.*;
 // This class will be used for Billing Details when Ordering...
@Entity
@Table(name="users_details")
public class CustomerDetails {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     @Column(name="user_detail_id")
    private int userDetailId;

     @OneToOne
     @JoinColumn(name="customer_user_id")
     private Customer customer;

     @Column(name="address")
     private String address;

     @Column(name="city")
     private String city;

     @Column(name="county")
     private String county;

     @Column(name="country")
     private String country;

     @Column(name="postalcode")
    private String postalcode;

     @Column(name="phone_number")
    private String phoneNumber;




     // Generate Default Constructor
    public CustomerDetails() {
    }

    // Parametrized Constructor
    public CustomerDetails(Customer customer, String address , String city , String county , String country , String postalcode , String phoneNumber){
        this.customer=customer;
        this.address=address;
        this.city=city;
        this.county=county;
        this.country=country;
        this.postalcode=postalcode;
        this.phoneNumber=phoneNumber;

    }

    // Generate Getters and Setters


                public int getUserDetailId() {
                    return userDetailId;
                }

                public void setUserDetailId(int userDetailId) {
                    this.userDetailId = userDetailId;
                }

     public Customer getCustomer() {
         return customer;
     }

     public void setCustomer(Customer customer) {
         this.customer = customer;
     }

     public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCounty() {
                    return county;
                }

                public void setCounty(String county) {
                    this.county = county;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getPostalcode() {
                    return postalcode;
                }

                public void setPostalcode(String postalcode) {
                    this.postalcode = postalcode;
                }

                public String getPhoneNumber() {
                    return phoneNumber;
                }

                public void setPhoneNumber(String phoneNumber) {
                    this.phoneNumber = phoneNumber;
                }

                // implement toString method just for visualisation the data :


     @Override
     public String toString() {
         return "CustomerDetails{" +
                 "userDetailId=" + userDetailId +
                 ", customer=" + customer +
                 ", address='" + address + '\'' +
                 ", city='" + city + '\'' +
                 ", county='" + county + '\'' +
                 ", country='" + country + '\'' +
                 ", postalcode='" + postalcode + '\'' +
                 ", phoneNumber='" + phoneNumber + '\'' +
                 '}';
     }
 }
