package com.country.service.demo;

import com.country.service.demo.api.ServiceController;
import com.country.service.demo.handlers.CountryHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ServiceController serviceController;
	@Autowired
	private CountryHandler countryHandler;

	@Test
	void countryListServiceTester() {
		System.out.println("The list of countries ===>>> " + serviceController.getCountries());
	}

	@Test
	void countryHandlerTester() {
		countryHandler.getCodes();
		countryHandler.getPopulation("nigeria");
		countryHandler.getCapital("nigeria");
		countryHandler.getFlagImage("NG");
	}
}
