package com.example.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dao.CustomerDao;
import com.example.customer.model.BillDetails;
import com.example.customer.model.BillDetailsResponse;
import com.example.customer.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	private static final int costPerUnit = 8; 
	
	public BillDetailsResponse saveRequest(BillDetails billDetails ) throws Exception{
		Optional<Customer> customer = 	customerDao.findByCustId(billDetails.getCustId());
		if(customer.isPresent()) {
			int totalAmount = billDetails.getUnits() * costPerUnit;
			billDetails.setBillAmount((double) totalAmount);
			
			int ackNo = customerDao.saveRequest(billDetails);
			BillDetailsResponse  response = new BillDetailsResponse(ackNo);
			response.setAckNo(ackNo);
			return response;
		}
		else {
			throw new Exception("User not present");
		}
		
	}
	public BillDetails getBill(int ackNo) throws Exception{
		Optional<BillDetails> billDetails = customerDao.findByAckNo(ackNo);
		if(billDetails.isPresent()) {
			return billDetails.get();
		}
		else {
			throw new Exception("Ack no is not present in database");
		}
		
	}
	public Customer getYearlyBill(int custId) {
		return customerDao.getYearlyBill(custId);
	}
}
