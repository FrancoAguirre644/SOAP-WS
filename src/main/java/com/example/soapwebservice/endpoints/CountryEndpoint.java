package com.example.soapwebservice.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapwebservice.services.ICountryService;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.CreateCountryRequest;
import io.spring.guides.gs_producing_web_service.CreateCountryResponse;
import io.spring.guides.gs_producing_web_service.DeleteCountryRequest;
import io.spring.guides.gs_producing_web_service.DeleteCountryResponse;
import io.spring.guides.gs_producing_web_service.GetAllCountriesResponse;
import io.spring.guides.gs_producing_web_service.ResponseStatus;
import io.spring.guides.gs_producing_web_service.UpdateCountryRequest;
import io.spring.guides.gs_producing_web_service.UpdateCountryResponse;

@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	@Qualifier("countryService")
	private ICountryService countryService;

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
	@ResponsePayload
	public CreateCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {

		CreateCountryResponse response = new CreateCountryResponse();
		ResponseStatus responseStatus = new ResponseStatus();

		Country country = entityToModel(countryService.insertOrUpdate(new com.example.soapwebservice.entities.Country(request.getName(), request.getPopulation(),
				request.getCapital(), request.getCurrency())));

		response.setCountry(country);

		responseStatus.setCode("0");
		responseStatus.setMessage("Created succesfully.");

		response.setReponseStatus(responseStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
	@ResponsePayload
	public UpdateCountryResponse updateCountry(@RequestPayload UpdateCountryRequest request) {

		UpdateCountryResponse response = new UpdateCountryResponse();
		ResponseStatus responseStatus = new ResponseStatus();
						
		entityToModel(countryService.insertOrUpdate(new com.example.soapwebservice.entities.Country(request.getCountry().getName(), request.getCountry().getPopulation(), request.getCountry().getCapital(),
				request.getCountry().getCurrency())));

		responseStatus.setCode("0");
		responseStatus.setMessage("Updated succesfully.");
		
		response.setResponseStatus(responseStatus);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
	@ResponsePayload
	public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {

		DeleteCountryResponse response = new DeleteCountryResponse();
		ResponseStatus responseStatus = new ResponseStatus();

		if (countryService.remove((int) request.getId())) {
			responseStatus.setCode("0");
			responseStatus.setMessage("Deleted succesfully.");
		} else {
			responseStatus.setCode("100");
			responseStatus.setMessage("Could not be deleted.");
		}

		response.setResponseStatus(responseStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
	@ResponsePayload
	public GetAllCountriesResponse getAllCountries() {

		GetAllCountriesResponse response = new GetAllCountriesResponse();

		for (com.example.soapwebservice.entities.Country c : countryService.getAll()) {
			response.getCountry().add(entityToModel(c));
		}

		return response;
	}
	
	public Country entityToModel(com.example.soapwebservice.entities.Country country) {
		
		Country c = new Country();
		
		c.setId(country.getId());
		c.setName(country.getName());
		c.setCapital(country.getCapital());
		c.setCurrency(country.getCurrency());
		c.setPopulation(country.getPopulation());
		
		return c;
	}

}
