package com.example.trading_platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Places {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "places_gen")
	@SequenceGenerator(name = "places_gen", sequenceName = "places_seq", allocationSize = 1)
	private long placeId;

	@Column
	private String city;

	@Column
	private String country;

	public Places() {
		super();
	}

	public Places(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (int) (placeId ^ (placeId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Places other = (Places) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (placeId != other.placeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Places [placeId=" + placeId + ", city=" + city + ", country=" + country + "]";
	}

}
