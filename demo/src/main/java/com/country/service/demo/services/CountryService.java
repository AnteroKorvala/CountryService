package com.country.service.demo.services;

import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.models.dtos.CountryResponseDto;

public interface CountryService {
    CountriesResponseDto getCountries();

    CountryResponseDto getCountry(String name);
}