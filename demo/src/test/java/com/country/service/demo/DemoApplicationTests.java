package com.country.service.demo;

import com.country.service.demo.api.ServiceController;
import com.country.service.demo.handlers.CountryHandler;
import com.country.service.demo.mappers.CountryMapper;
import com.country.service.demo.models.*;
import com.country.service.demo.models.dtos.CountryDto;
import com.country.service.demo.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	private final String name = "nigeria";
	private final String iso2 = "NG";

	@Autowired
	private ServiceController serviceController;
	@Autowired
	private CountryHandler countryHandler;
	@Autowired
	private CountryMapper countryMapper;
	@Autowired
	private CountryService countryService;

	@Test
	void serviceControllerTester() {
		var countries = serviceController.getCountries();
		var country = serviceController.getCountry(name);
		System.out.println(countries);
		System.out.println(country);
	}

	@Test
	void countryHandlerTester() {
		countryHandler.getCodes();
		countryHandler.getPopulation(name);
		countryHandler.getCapital(name);
		countryHandler.getFlagImage(iso2);
	}

	@Test
	void countryMapperTester() {
		String dial_code = "+234";
		var countryCodeModel =
				new CountryCodeModel(name, iso2, dial_code);
		CountryDto countryDtoA = new CountryDto(name, iso2);
		List<CountryDto> countryDtos = new ArrayList<CountryDto>();
		countryDtos.add(countryDtoA);
		String iso3 = "NGA";
		String capital = "Abuja";
		CapitalModel capitalModel = new CapitalModel(name, capital, iso2, iso3);
		PopulationCountModel populationCountModel = new PopulationCountModel(2018, 195874740);
		List<PopulationCountModel> populationCountModels = new ArrayList<PopulationCountModel>();
		populationCountModels.add(populationCountModel);
		PopulationModel populationModel = new PopulationModel(
				name,
				iso2,
				iso3,
				populationCountModels
		);
		String flagImage = "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg";
		FlagImageModel flagImageModel = new FlagImageModel(
				name,
				flagImage,
				iso2,
				iso3
		);

		countryMapper.toDto(countryCodeModel);
		countryMapper.toDto(countryDtos);
		countryMapper.toDto(capitalModel, populationModel, flagImageModel);
	}

	@Test
	void countryServiceTester() {
		countryService.getCountries();
		countryService.getCountry(name);
	}
}
