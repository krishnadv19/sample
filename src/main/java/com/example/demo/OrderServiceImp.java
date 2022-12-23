package com.example.demo;

import java.util.List;

import com.example.demo.model.Order;

public interface OrderServiceImp {
   List<Order> findOrderAll(Order order);
   
   
}
