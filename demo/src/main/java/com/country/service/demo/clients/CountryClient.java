package com.country.service.demo.clients;

import com.country.service.demo.models.CapitalModel;
import com.country.service.demo.models.CountryCodeModel;
import com.country.service.demo.models.FlagImageModel;
import com.country.service.demo.models.PopulationModel;
import com.country.service.demo.models.requests.CapitalRequest;
import com.country.service.demo.models.requests.FlagImageRequest;
import com.country.service.demo.models.requests.PopulationRequest;
import com.country.service.demo.models.responses.ListResponse;
import com.country.service.demo.models.responses.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://countriesnow.space/api/v0.1", name = "countries")
public interface CountryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/countries/codes")
    ListResponse<CountryCodeModel> findAllCodes();

    @RequestMapping(method = RequestMethod.POST, value = "/countries/population")
    Response<PopulationModel> findPopulation(PopulationRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/countries/flag/images")
    Response<FlagImageModel> findFlagImage(FlagImageRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/countries/capital")
    Response<CapitalModel> findCapital(CapitalRequest request);
}
