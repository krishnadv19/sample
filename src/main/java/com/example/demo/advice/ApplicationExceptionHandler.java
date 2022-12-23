package com.example.demo.advice;


import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.OrderNotFoundException;


@RestControllerAdvice
public class ApplicationExceptionHandler {
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
         @ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String,String> hndleException(MethodArgumentNotValidException ex ,BindingResult result){
        	 Map<String,String> errormap=new HashMap<>();
        	 
        	 result.getFieldErrors().forEach(error -> {
        		 errormap.put(error.getField(), error.getDefaultMessage());
        	 });
			return errormap;
        	 
         }
	     
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	     @ExceptionHandler(OrderNotFoundException.class)
	     public Map<String, String> handleUserException(OrderNotFoundException ex){
        	 Map<String,String> errrmap=new HashMap<>();
            errrmap.put("errormessage", ex.getMessage());
			return errrmap;
	    	 
	     }
	     
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	     @ExceptionHandler(InvalidDataAccessApiUsageException.class)
	     public Map<String, String> handleenum(InvalidDataAccessApiUsageException ex){
        	 Map<String,String> errrmap=new HashMap<>();
            errrmap.put("errormessage", ex.getMessage());
			return errrmap;
	    
	     
	     }
	     
	
	
}
