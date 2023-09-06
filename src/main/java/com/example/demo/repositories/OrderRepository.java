package com.example.demo.repositories;

import com.example.demo.entities.Books;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("SELECT u FROM Order u WHERE u.orderStatus = 2")
    List<Order> findExpiredOrder();

}
