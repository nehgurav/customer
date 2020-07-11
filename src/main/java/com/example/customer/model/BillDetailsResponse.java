package com.example.customer.model;

public class BillDetailsResponse {

	private int ackNo;

	public BillDetailsResponse(int ackNo) {
		this.ackNo = ackNo;
	}
	
	public int getAckNo() {
		return ackNo;
	}

	public void setAckNo(int ackNo) {
		this.ackNo = ackNo;
	}
}
