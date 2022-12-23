package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	Order save(Order order);
	
	Order findById(long id);
  
	@Modifying
	@Transactional
	@Query("Update Order  set orderName=:orderName where id=:id")
	Integer update(String orderName,long id );
	
	Integer deleteById(long id);
	
	
}
