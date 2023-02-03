package com.country.service.demo.mappers;

import com.country.service.demo.models.*;
import com.country.service.demo.models.dtos.CountriesResponseDto;
import com.country.service.demo.models.dtos.CountryDto;
import com.country.service.demo.models.dtos.CountryResponseDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDto toDto(CountryCodeModel model) {
        return new CountryDto(model.name(), model.code());
    }

    @Override
    public CountriesResponseDto toDto(List<CountryDto> countries) {
        return new CountriesResponseDto(countries);
    }

    @Override
    public CountryResponseDto toDto(CapitalModel capital, PopulationModel population, FlagImageModel flagImage) {
        var populationCount = getPopulationCount(population);

        return new CountryResponseDto(
                population.country(),
                flagImage.iso2(),
                capital.capital(),
                populationCount,
                flagImage.flag()
        );
    }

    private static Integer getPopulationCount(final PopulationModel population) {
        return population.populationCounts()
                .stream()
                .max(Comparator.comparingInt(PopulationCountModel::year))
                .map(PopulationCountModel::value)
                .orElse(0);
    }
}
