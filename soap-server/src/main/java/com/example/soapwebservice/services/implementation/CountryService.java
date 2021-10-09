package com.example.soapwebservice.services.implementation;

import java.util.List;

import com.example.soapwebservice.entities.Country;
import com.example.soapwebservice.repositories.ICountryRepository;
import com.example.soapwebservice.services.ICountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("countryService")
public class CountryService implements ICountryService {

	@Autowired
	@Qualifier("countryRepository")
	private ICountryRepository countryRepository;

	@Override
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country insertOrUpdate(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public boolean remove(int id) {
		try {
			countryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Country findById(int id) {
		return countryRepository.findById(id);
	}
}
