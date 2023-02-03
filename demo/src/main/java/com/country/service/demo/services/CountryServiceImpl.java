package com.country.service.demo.services;

import com.country.service.demo.mappers.CountryMapper;
import com.country.service.demo.models.CountryCodeModel;
import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.handlers.CountryHandler;
import com.country.service.demo.models.dtos.CountryResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryHandler countryHandler;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(final CountryHandler countryHandler, final CountryMapper countryMapper) {
        this.countryHandler = countryHandler;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountriesResponseDto getCountries() {
        var codeModels = countryHandler.getCodes();
        var codeDtos = codeModels
                .stream()
                .map(countryMapper::toDto)
                .toList();

        return countryMapper.toDto(codeDtos);
    }

    @Override
    public CountryResponseDto getCountry(final String name) {
        var capital = countryHandler.getCapital(name);
        var population = countryHandler.getPopulation(name);
        var flagImage = countryHandler.getFlagImage(capital.iso2());

        return countryMapper.toDto(capital, population, flagImage);
    }
}
