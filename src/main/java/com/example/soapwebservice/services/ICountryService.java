package com.example.soapwebservice.services;

import java.util.List;

import com.example.soapwebservice.entities.Country;

public interface ICountryService {
	
	public List<Country> getAll();
	
	public Country insertOrUpdate(Country Country);
	
	public boolean remove(int id);

}
