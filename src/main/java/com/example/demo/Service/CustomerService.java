package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.Customerdao;
import com.example.demo.dto.Customer;
import com.example.demo.responseStructure.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private Customerdao customerdao;
	

		public ResponseStructure<?> insertCustomer(Customer customer){
			
		Customer cust = customerdao.insertCustomer(customer);
		
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.CREATED);  //201
		
		return responseStructure;
		
	}

		public ResponseStructure<?> findALLCustomer() {
			
	    List<Customer> customerList  = customerdao.findAllCustomer();
	    
			ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
			responseStructure.setData(customerList);
			responseStructure.setHttpStatus(HttpStatus.OK);
			return responseStructure;
		}


		public ResponseStructure<?> findCustById(int custid) {
			
		  Optional<Customer> findCustById = customerdao.findCustById(custid);
		  
		  if(findCustById.isPresent()) {
			  ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			  Customer customer = findCustById.get();
			  responseStructure.setData(customer);
			  responseStructure.setHttpStatus(HttpStatus.OK);
				return responseStructure;
		  }
		  else {
			  ResponseStructure<String> responseStructure = new ResponseStructure<>();
			  responseStructure.setData("Customer Not Found");
			  responseStructure.setHttpStatus(HttpStatus.OK);
				return responseStructure;
		  }
		  
		}
}
