package com.example.customer.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customer.model.BillDetails;
import com.example.customer.model.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerBillDetailsRepository customerBillDetailsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public int saveRequest(BillDetails billDetails ) {
		BillDetails details = customerBillDetailsRepository.save(billDetails);
		return details.getAckNo();
		
	}
	
	public Optional<Customer> findByCustId(int custId) {
		return customerRepository.findById(custId);
		
	}
	public Optional<BillDetails> findByAckNo(int ackNo) {
		return customerBillDetailsRepository.findById(ackNo);
		
	}
	public Customer getYearlyBill(int custId) {
		
		return customerRepository.findCustomerByCustIdAndBillDetailsDateBetween(custId, LocalDate.now().minusYears(1),LocalDate.now() );
	}
}
