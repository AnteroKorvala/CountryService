package com.country.service.demo.handlers;

import com.country.service.demo.clients.CountryClient;
import com.country.service.demo.models.CapitalModel;
import com.country.service.demo.models.CountryCodeModel;
import com.country.service.demo.models.FlagImageModel;
import com.country.service.demo.models.PopulationModel;
import com.country.service.demo.models.requests.CapitalRequest;
import com.country.service.demo.models.requests.FlagImageRequest;
import com.country.service.demo.models.requests.PopulationRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryHandlerImpl implements CountryHandler {

    private final CountryClient countryClient;

    public CountryHandlerImpl(final CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @Override
    @Cacheable("countries")
    public List<CountryCodeModel> getCodes() {
        //TODO handle status of response
        return countryClient.findAllCodes().data();
    }

    @Override
    @Cacheable(value = "population", key = "#country")
    public PopulationModel getPopulation(final String country) {
        var request = new PopulationRequest(country);
        var response = countryClient.findPopulation(request);
        //TODO Handle status of response
        return response.data();
    }

    @Override
    @Cacheable(value = "capital", key = "#country")
    public CapitalModel getCapital(final String country) {
        var request = new CapitalRequest(country);
        var response = countryClient.findCapital(request);
        //TODO Handle status of response
        return response.data();
    }

    @Override
    @Cacheable(value = "flagImage", key = "#iso2")
    public FlagImageModel getFlagImage(final String iso2) {
        var request = new FlagImageRequest(iso2);
        var response = countryClient.findFlagImage(request);
        //TODO Handle status of response
        return response.data();
    }
}
