package com.country.service.demo.models;

import java.util.List;

public record PopulationModel(
        String country,
        String code,
        String iso3,
        List<PopulationCountModel> populationCounts
) { }
