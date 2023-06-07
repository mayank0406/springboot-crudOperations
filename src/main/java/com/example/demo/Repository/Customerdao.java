package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.Customer;
import com.example.demo.exception.CustomerIdNotFoundException;

@Repository
public class Customerdao {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	//simple jpaRepository object--> curd operations method
	
	public Customer insertCustomer(Customer customer){
		
		return customerRepository.save(customer); //peristence logic
	 }

	public List<Customer> findAllCustomer() {
		
		return customerRepository.findAll();
	}

	
	
	public Optional<Customer> findCustById(int custid) {

		Optional<Customer> FindById = customerRepository.findById(custid);
		return FindById;
	}
	
	public Customer deleteCustomer(int custid)
	{
	Optional<Customer> findById = customerRepository.findById(custid);
	
	//if it is true
	if(findById.isPresent())
	{
		customerRepository.deleteById(custid);
		return findById.get();
	}
	else {		
		throw new CustomerIdNotFoundException("Customer Id Not Found");
	}
	
	}
	
	public 	Customer updateCustomer(Customer customer) {
		Optional<Customer> findById = customerRepository.findById(customer.getCusid());
		
		if(findById.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerIdNotFoundException("Customer ID not available for updation");
	}

	public Customer partupdate(int custid, long phno) {
    Optional<Customer> customer = customerRepository.findById(custid);
		
		if(customer.isPresent()) {
			Customer custom = customer.get();
			custom.setPhno(phno);
			return customerRepository.save(custom);
		}
		throw new CustomerIdNotFoundException("Customer ID not available for updation");

	}

	

	
}
