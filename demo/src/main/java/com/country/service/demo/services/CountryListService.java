package com.country.service.demo.services;

import com.country.service.demo.models.CountryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryListService implements ICountryListService {
    
    @Override
    public List<?> getCountryList() {
        return null;
    }

    @Override
    public CountryModel getCountryInfo() {
        return null;
    }
}
