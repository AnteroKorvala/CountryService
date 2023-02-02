package com.country.service.demo.models;

public class CountryModel {

    private final String name;
    private final String country_code;
    private final String capital;
    private final Integer population;
    private final String flag_file_url;

    public CountryModel(String name, String country_code, String capital, Integer population, String flag_file_url) {
        this.name = name;
        this.country_code = country_code;
        this.capital = capital;
        this.population = population;
        this.flag_file_url = flag_file_url;
    }

    public String getName() {
        return name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCapital() {
        return capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public String getFlag_file_url() {
        return flag_file_url;
    }
}
