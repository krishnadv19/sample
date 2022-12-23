package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.OrderServiceImp;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService implements OrderServiceImp{
	
	@Autowired
    private OrderRepository orderRepository;
	public Order savingOrder(Order order) {
		return orderRepository.save(order);
		
	}
	
	public Order getOrders(long id) throws OrderNotFoundException {
		Order order= orderRepository.findById(id);
		if(order!=null) {
			return order;
		}
		else {
			throw new OrderNotFoundException("User Not found with id:"+id);
		}
	}
		
	
	public Integer updateOrder(String orderName,long id) {
		 
		return orderRepository.update(orderName , id);
		
	}

	@Override
	public List<Order> findOrderAll(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

		
	public Integer delete(long id) {
		return orderRepository.deleteById(id);
	}
	
	
	
	
}
