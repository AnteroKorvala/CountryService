package com.country.service.demo;

import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.models.dtos.CountryDto;
import com.country.service.demo.models.dtos.CountryResponseDto;
import com.country.service.demo.services.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTests {

    private final String name = "nigeria";
    @Mock
    private CountryService countryService;

    @Test
    public void countryService_GetCountries() {
        String iso2 = "NG";
        CountryDto countryDtoA = new CountryDto(name, iso2);
		List<CountryDto> countryDtos = new ArrayList<>();
		countryDtos.add(countryDtoA);
        CountriesResponseDto countriesResponseDto =
                new CountriesResponseDto(countryDtos);

        Mockito.when(countryService.getCountries())
                .thenReturn(countriesResponseDto);

        CountriesResponseDto response = countryService.getCountries();

        Assert.assertEquals(countriesResponseDto, response);
        Mockito.verify(countryService).getCountries();
    }

    @Test
    public void countryService_GetCountry() {
        final String capital = "Abuja";
        final String code = "NG";
        final int population = 195874740;
        final String flagImage =
                "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg";
        CountryResponseDto countryResponseDto =
                new CountryResponseDto(name, capital, code, population, flagImage);

        Mockito.when(countryService.getCountry(name))
                .thenReturn(countryResponseDto);

        CountryResponseDto response =
                countryService.getCountry(name);

        Assert.assertEquals(countryResponseDto, response);
        Mockito.verify(countryService).getCountry(name);
    }
}
