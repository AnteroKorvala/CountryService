package com.country.service.demo.models.dtos;

public record CountryResponseDto(
        String name,
        String capital,
        String country_code,
        int population,
        String flag_file_url
) { }
