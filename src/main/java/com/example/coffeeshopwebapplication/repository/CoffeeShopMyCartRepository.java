package com.example.coffeeshopwebapplication.repository;

import com.example.coffeeshopwebapplication.entity.CoffeeShopMyCartElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CoffeeShopMyCartRepository extends JpaRepository<CoffeeShopMyCartElement ,Integer> {
 CoffeeShopMyCartElement findById(int id);

 @Transactional
@Modifying
 @Query("UPDATE CoffeeShopMyCartElement u set u.numberOfCoffees = :numberOfCoffees where u.orderId= :id")
 public void updateQuantity(@Param("id") int id , @Param("numberOfCoffees") int numberOfCoffees);

 @Transactional
 @Modifying
 @Query("update CoffeeShopMyCartElement c set c.totalPrice= :totalPrice where c.orderId= :id")
 public void updatePrice(@Param("id") int it , @Param("totalPrice") float totalPrice);


 @Query("select sum(m.totalPrice) from CoffeeShopMyCartElement m")
 public int getSum();

 void deleteAll();


}
