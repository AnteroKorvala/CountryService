package com.country.service.demo.mappers;

import com.country.service.demo.models.CapitalModel;
import com.country.service.demo.models.CountryCodeModel;
import com.country.service.demo.models.FlagImageModel;
import com.country.service.demo.models.PopulationModel;
import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.models.dtos.CountryDto;
import com.country.service.demo.models.dtos.CountryResponseDto;

import java.util.List;

public interface CountryMapper {

    CountryDto toDto(CountryCodeModel model);
    CountriesResponseDto toDto(List<CountryDto> countries);
    CountryResponseDto toDto(CapitalModel capital, PopulationModel population, FlagImageModel flagImage);
}
