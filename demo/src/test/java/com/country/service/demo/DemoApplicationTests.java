package com.country.service.demo;

import com.country.service.demo.api.ServiceController;
import com.country.service.demo.handlers.CountryHandler;
import com.country.service.demo.mappers.CountryMapper;
import com.country.service.demo.models.*;
import com.country.service.demo.models.dtos.CountryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ServiceController serviceController;
	@Autowired
	private CountryHandler countryHandler;
	@Autowired
	private CountryMapper countryMapper;

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

	@Test
	void countryMapperTester() {
		var countryCodeModel =
				new CountryCodeModel("nigeria", "NG", "+234");
		CountryDto countryDtoA = new CountryDto("nigeria", "NG");
		List<CountryDto> countryDtos = new ArrayList<CountryDto>();
		countryDtos.add(countryDtoA);
		CapitalModel capitalModel = new CapitalModel("nigeria", "Abuja", "NG", "NGA");
		PopulationCountModel populationCountModel = new PopulationCountModel(2018, 195874740);
		List<PopulationCountModel> populationCountModels = new ArrayList<PopulationCountModel>();
		populationCountModels.add(populationCountModel);
		PopulationModel populationModel = new PopulationModel(
				"nigeria",
				"NG",
				"NGA",
				populationCountModels
		);
		FlagImageModel flagImageModel = new FlagImageModel(
				"nigeria",
				"https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg",
				"NG",
				"NGA"
		);

		countryMapper.toDto(countryCodeModel);
		countryMapper.toDto(countryDtos);
		countryMapper.toDto(capitalModel, populationModel, flagImageModel);
	}
}
