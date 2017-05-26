package mx.rest.shop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mx.rest.shop.model.Customer;
import mx.rest.shop.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/getAllCustomer", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getCustomer() {		
		List<Customer> listOfCustomer = customerService.getAllCustomer();
		return listOfCustomer;
	}	

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {		
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getCustomerByDate(@RequestParam("updateDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date updateDate) {
		List<Customer> listOfCustomer = customerService.getCustomer(updateDate);
		return listOfCustomer;
	}
	
	@RequestMapping(value = "/getCustomerFromTo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getCustomerFromTo(@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		List<Customer> listOfCustomer = customerService.getCustomer(fromDate,toDate);
		return listOfCustomer;
	}
}
