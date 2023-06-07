package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CustomerService;
import com.example.demo.dto.Customer;
import com.example.demo.responseStructure.ResponseStructure;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer)
	{
		ResponseStructure<?> responseStructure = customerService.insertCustomer(customer);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}

	
	@GetMapping( path = "/fetchAll")
	public ResponseEntity<?> findAllCustomer(){
		
		ResponseStructure<?> responseStructure = customerService.findALLCustomer();
		
		return new ResponseEntity<> (responseStructure , responseStructure.getHttpStatus());
	}
	
	@GetMapping( path = "/fetchById/{cusid}")
	public ResponseEntity<?> findCustById(@PathVariable int cusid){
		
		ResponseStructure<?> responseStructure = customerService.findCustById(cusid);
		
		return new ResponseEntity<> (responseStructure, responseStructure.getHttpStatus());
	}
	 
	@DeleteMapping(path = "/delete/{custid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int custid){
		ResponseStructure<?> responseStructure = customerService.deleteCustomer(custid);
		return new ResponseEntity<> (responseStructure , responseStructure.getHttpStatus());
		
	}	
	
	//update the customer
	//@putMapping-->update the complete resource
	//@patchmapping-->partical update of the resource
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		ResponseStructure<?> responseStructure = customerService.updateCustomer(customer);
		return new ResponseEntity<> (responseStructure,responseStructure.getHttpStatus());
	}
	
	 
	//when u want to update only one attribute
	@PatchMapping(path = "/partialupdate/{phno}")
	public ResponseEntity<?> partupdate(@RequestParam int custid , @RequestParam long phno){
		
		ResponseStructure<?> responseStructure = customerService.partupdate(custid,phno);
		return new ResponseEntity<> (responseStructure, responseStructure.getHttpStatus());
	}	
}
