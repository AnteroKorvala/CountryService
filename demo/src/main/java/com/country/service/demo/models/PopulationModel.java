package com.country.service.demo.models;

import java.util.List;

public record PopulationModel(
        String country,
        String code,
        String iso3,
        List<PopulationCountModel> populationCounts
) { }
/*
public class PopulationModel {
    private String country;
    private String code;
    private String iso3;
    private List<PopulationCountModel> populationCounts;

    public PopulationModel(String country, String code, String iso3, List<PopulationCountModel> populationCounts) {
        this.country = country;
        this.code = code;
        this.iso3 = iso3;
        this.populationCounts = populationCounts;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public List<PopulationCountModel> getPopulationCounts() {
        return populationCounts;
    }

    public void setPopulationCounts(List<PopulationCountModel> populationCounts) {
        this.populationCounts = populationCounts;
    }
}
*/
