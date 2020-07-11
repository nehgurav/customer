package com.example.customer.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findCustomerByCustIdAndBillDetailsDateBetween(int custId,LocalDate startDate, LocalDate endDate ) ;
}
