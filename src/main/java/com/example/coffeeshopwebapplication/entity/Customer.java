package com.example.coffeeshopwebapplication.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int customerId;

    @Column(name="first_name")
    @NotBlank(message=" is required")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message=" is required")
    private String lastName;

    @Column(name="user_name")
    @NotBlank(message=" is required")
    private String username;

    @Column(name="email")
    @NotBlank(message=" is required")
    private String email;

    @Column(name="password" , nullable=false)
    @NotBlank(message=" is required")
    private String password;

    // Default Constructor
    public Customer(){

    }
    // Parametrized Constructor
    public Customer(  int customerId ,String firstName , String lastName , String username , String email , String password){
        this.customerId=customerId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    // Generate Getters and Setters


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
