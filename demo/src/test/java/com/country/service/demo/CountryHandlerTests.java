package com.country.service.demo;

import com.country.service.demo.handlers.CountryHandler;
import com.country.service.demo.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CountryHandlerTests {

    private final String name = "nigeria";
    private final String iso2 = "NG";
    private final String iso3 = "NGA";
    @Mock
    private CountryHandler countryHandler;

    @Test
    public void countryHandler_getCodes() {
        String dial_code = "+234";
        CountryCodeModel countryCodeModel =
                new CountryCodeModel(name, iso2, dial_code);
        List<CountryCodeModel> countryCodeModels = new ArrayList<>();
        countryCodeModels.add(countryCodeModel);

        Mockito.when(countryHandler.getCodes())
                .thenReturn(countryCodeModels);

        List<CountryCodeModel> response = countryHandler.getCodes();

        Assert.assertEquals(countryCodeModels, response);
        Mockito.verify(countryHandler).getCodes();
    }

    @Test
    public void countryHandler_getCapital() {

        String capital = "Abuja";
        CapitalModel capitalModel =
                new CapitalModel(name, capital, iso2, iso3);

        Mockito.when(countryHandler.getCapital(name))
                .thenReturn(capitalModel);

        CapitalModel response = countryHandler.getCapital(name);

        Assert.assertEquals(capitalModel, response);
        Mockito.verify(countryHandler).getCapital(name);
    }

    @Test
    public void countryHandler_getFlagImage() {

        String flag = "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg";
        FlagImageModel flagImageModel =
                new FlagImageModel(name, flag, iso2, iso3);

        Mockito.when(countryHandler.getFlagImage(iso2))
                .thenReturn(flagImageModel);

        FlagImageModel response = countryHandler.getFlagImage(iso2);

        Assert.assertEquals(flagImageModel, response);
        Mockito.verify(countryHandler).getFlagImage(iso2);
    }

    @Test
    public void countryHandler_get() {
        PopulationCountModel populationCountModel =
                new PopulationCountModel(2018, 195874740);
        List<PopulationCountModel> populationCounts =
                new ArrayList<>();
        populationCounts.add(populationCountModel);

        PopulationModel populationModel =
                new PopulationModel(name, iso2, iso3, populationCounts);

        Mockito.when(countryHandler.getPopulation(name))
                .thenReturn(populationModel);

        PopulationModel response = countryHandler.getPopulation(name);

        Assert.assertEquals(populationModel, response);
        Mockito.verify(countryHandler).getPopulation(name);
    }
}
