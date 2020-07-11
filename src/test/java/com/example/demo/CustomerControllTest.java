package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.customer.CustomerApplication;
import com.example.customer.controller.CustomerController;
import com.example.customer.model.BillDetails;
import com.example.customer.model.BillDetailsResponse;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
//@WebMvcTest(CustomerController.class)
@SpringBootTest(classes = CustomerApplication.class)
@AutoConfigureMockMvc
public class CustomerControllTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService service;

	@Test
	public void testSaveRequest() throws Exception {

		BillDetails billDetails = getBillDetails();
		when(service.saveRequest(getBillDetails())).thenReturn(new BillDetailsResponse(100));
		mockMvc.perform(post("/bill").contentType(MediaType.APPLICATION_JSON).content(toJson(billDetails)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.ackNo", is("100")));

		this.mockMvc.perform(post("/bill")).andExpect(status().isOk())
				.andExpect(content().string(containsString("100")));
		// assertNotEquals(0, billDetailsResponse.getAckNo());
		;
	}

	private BillDetails getBillDetails() {
		BillDetails billDetails = new BillDetails();
		billDetails.setCustId(1);
		billDetails.setDate(LocalDate.now());
		billDetails.setUnits(500);
		return billDetails;
	}
	 byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	       // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }
}
