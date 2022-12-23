package com.example.demo.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator = "order_generator")
	  @SequenceGenerator(name = "order_generator",sequenceName = "order_seq",allocationSize = 1)
	@Column(name="order_id")
   private long id;
   
	@Column(name="order_name")
	@NotEmpty(message="order Name should not be empty")
   private String orderName;
	@NotEmpty(message="order payment should not be empty")
	@Column(name="pytment_method")
	private String payment;
	@Column(name="order_adress")
	@Enumerated(EnumType.STRING)
	private Address address;
}
