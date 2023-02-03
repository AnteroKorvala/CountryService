package com.country.service.demo.handlers;

import com.country.service.demo.models.CapitalModel;
import com.country.service.demo.models.CountryCodeModel;
import com.country.service.demo.models.FlagImageModel;
import com.country.service.demo.models.PopulationModel;

import java.util.List;

public interface CountryHandler {

    List<CountryCodeModel> getCodes();
    PopulationModel getPopulation(String country);
    CapitalModel getCapital(String country);
    FlagImageModel getFlagImage(String iso2);
}
