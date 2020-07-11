package com.example.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.model.BillDetails;

@Repository
public interface CustomerBillDetailsRepository extends JpaRepository<BillDetails, Integer> {

}
