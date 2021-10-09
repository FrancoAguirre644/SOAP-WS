package com.example.soapwebservice.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.soapwebservice.entities.Country;

@Repository("countryRepository")
public interface ICountryRepository extends JpaRepository<Country, Serializable> {
	public abstract Country findById(int id);
}
