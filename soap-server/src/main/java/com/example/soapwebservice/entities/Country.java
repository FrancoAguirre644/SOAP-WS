package com.example.soapwebservice.entities;

import java.time.LocalDateTime;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "population")
	private int population;

	@Column(name = "capital")
	private String capital;

	@Column(name = "currency")
	private String currency;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Country() {
		super();
	}

	public Country(int id, String name, int population, String capital, String currency) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.capital = capital;
		this.currency = currency;
	}

	public Country(String name, int population, String capital, String currency) {
		super();
		this.name = name;
		this.population = population;
		this.capital = capital;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", population=" + population + ", capital=" + capital
				+ ", currency=" + currency + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}