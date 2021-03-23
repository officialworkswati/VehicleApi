package com.demo.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class VehicleApplicationTests
{


	@Autowired
	WebApplicationContext webApplicationContext;


	private MockMvc mockMvc;

	@Before
	public void setup(){
		System.out.println("before");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


	@Test
	public void addVehicle() throws Exception
	{
		System.out.println("before");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String exampleJson = "{ \n" + "\"vin\": \"1A4AABBC5KD501999\",\n" + "\"year\": 2019,\n" + "\"make\":\"FCA\",\n" +  "\"model\":\"RAM\",\n" +  "\"transmissionType\":\"MANUAL\"\n" + "}";
		System.out.println(exampleJson);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/vehicle-api/v1/vehicles/vehicle")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson)
				.contentType(MediaType.APPLICATION_JSON);

		int result = mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus();
		System.out.println(result);
		Assert.assertEquals(200,result);
	}




}
