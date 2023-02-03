package com.country.service.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("/countries/")
    public ResponseEntity<?> CountryList() {
        return ResponseEntity.ok(1);
    }
}
