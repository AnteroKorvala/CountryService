package com.country.service.demo.api;

import com.country.service.demo.services.CountryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
public class ServiceController {

    private final CountryServiceImpl countryService;

    public ServiceController(CountryServiceImpl countryListService) {
        this.countryService = countryListService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getCountries() {
        var countriesResponse = countryService.getCountries();
        return ResponseEntity.ok(countriesResponse);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCountry(@PathVariable final String name) {
        var countryResponse = countryService.getCountry(name);
        return ResponseEntity.ok(countryResponse);
    }
}
