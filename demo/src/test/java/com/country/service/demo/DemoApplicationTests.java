package com.country.service.demo;

import com.country.service.demo.api.ServiceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ServiceController serviceController;

	@Test
	void countryListServiceTester() {
		System.out.println("The list of countries ===>>> " + serviceController.CountryList());
	}

}
