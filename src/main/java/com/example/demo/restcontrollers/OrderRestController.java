package com.example.demo.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.services.OrderService;

@RestController
public class OrderRestController {
	 @Autowired 
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<String> getOrder(@Valid @RequestBody Order order){
		orderService.savingOrder(order);
		return new ResponseEntity<String>("Its done",HttpStatus.CREATED);
	}
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<Order> getOrders(@PathVariable long id) throws OrderNotFoundException {
		
		return new ResponseEntity<Order>(orderService.getOrders(id),HttpStatus.OK);
		
	}
		
	
	@PutMapping("/update/{orderName}/{id}")
	public String putOrder(@PathVariable String orderName,@PathVariable long id) {
		
		return orderService.updateOrder(orderName, id)+"order updated";
	}
     
	@GetMapping("/getall")
	public List<Order> getAllOrder(Order order){
		return orderService.findOrderAll(order);
		
	}
	
	@DeleteMapping("/del/{id}")
	public String deleteOrder(@PathVariable long id) {
	 orderService.delete(id);
	return "Sucessfully Deleted";
	}
	
	
}
