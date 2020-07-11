package com.example.customer.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BillDetails {

	@Column(name = "ackNo")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ackNo;
	
	@Column(name = "custId")
	private int custId;
	
	@Column(name = "date")
	@JsonFormat(pattern="dd/MM/yyyy" )
	//@Temporal(TemporalType.DATE)
	private LocalDate date;
	
	@Column(name = "units")
	private int units;
	
	@Column(name = "billamount")
	private Double billAmount;

	public int getAckNo() {
		return ackNo;
	}

	public void setAckNo(int ackNo) {
		this.ackNo = ackNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public LocalDate getDate() {
		return date;
	}

	@JsonFormat(pattern="dd/MM/yyyy", timezone = "Asia/Kolkata")
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
}
