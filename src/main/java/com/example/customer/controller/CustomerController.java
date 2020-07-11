package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.BillDetails;
import com.example.customer.model.BillDetailsResponse;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/bill")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	public BillDetailsResponse saveRequest(@RequestBody BillDetails billDetails ) throws Exception {
		return customerService.saveRequest(billDetails);
		
	}
	@RequestMapping(value = "/{ackNo}", method = RequestMethod.GET)
	public BillDetails getBill(@PathVariable int ackNo) throws Exception {
		return customerService.getBill(ackNo);
		
	}
	@RequestMapping(value = "/yearwise/{custId}", method = RequestMethod.GET)
	public Customer getYearlyBill(@PathVariable int custId) throws Exception {
		return customerService.getYearlyBill(custId);
		
	}
}
