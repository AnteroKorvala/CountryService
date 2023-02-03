package com.country.service.demo;

import com.country.service.demo.mappers.CountryMapper;
import com.country.service.demo.models.*;
import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.models.dtos.CountryDto;
import com.country.service.demo.models.dtos.CountryResponseDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CountryMapperTests {

    private final String name = "nigeria";
    private final String iso2 = "NG";
    @Mock
    private CountryMapper countryMapper;

    @Test
    public void countryMapper_toDto_countryDto() {
        String dial_code = "+234";
        CountryCodeModel countryCodeModel =
                new CountryCodeModel(name, iso2, dial_code);
        CountryDto countryDto =
                new CountryDto(name,iso2);

        Mockito.when(countryMapper.toDto(countryCodeModel))
                .thenReturn(countryDto);

        CountryDto response = countryMapper.toDto(countryCodeModel);

        Assert.assertEquals(countryDto, response);
        Mockito.verify(countryMapper).toDto(countryCodeModel);
    }

    @Test
    public void countryMapper_toDto_countriesResponseDto() {
        CountryDto countryDtoA = new CountryDto(name, iso2);
        List<CountryDto> countryDtos = new ArrayList<>();
        countryDtos.add(countryDtoA);
        CountriesResponseDto countriesResponseDto =
                new CountriesResponseDto(countryDtos);

        Mockito.when(countryMapper.toDto(countryDtos))
                .thenReturn(countriesResponseDto);

       CountriesResponseDto response =
               countryMapper.toDto(countryDtos);

       Assert.assertEquals(countriesResponseDto, response);
       Mockito.verify(countryMapper).toDto(countryDtos);
    }

    @Test
    public void countryMapper_toDto_countryResponseDto() {
        final String capital = "Abuja";
        final String iso3 = "NGA";
        final int population = 195874740;

        CapitalModel capitalModel = new CapitalModel(name, capital, iso2, iso3);

        PopulationCountModel populationCountModel = new PopulationCountModel(2018, 195874740);
        List<PopulationCountModel> populationCountModels = new ArrayList<>();
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
        
        CountryResponseDto countryResponseDto =
                new CountryResponseDto(name, capital, iso2, population, flagImage);

        Mockito.when(countryMapper.toDto(capitalModel, populationModel, flagImageModel))
                .thenReturn(countryResponseDto);

        CountryResponseDto response =
                countryMapper.toDto(capitalModel, populationModel, flagImageModel);

        Assert.assertEquals(countryResponseDto, response);
        Mockito.verify(countryMapper).toDto(capitalModel, populationModel, flagImageModel);
    }
}
