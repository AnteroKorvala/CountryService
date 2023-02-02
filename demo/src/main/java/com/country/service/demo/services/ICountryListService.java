package com.country.service.demo.services;

import com.country.service.demo.models.CountryModel;

import java.util.List;

public interface ICountryListService {
    List<?> getCountryList();
    CountryModel getCountryInfo();
}
