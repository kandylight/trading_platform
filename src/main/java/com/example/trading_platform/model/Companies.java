package com.example.trading_platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Companies {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_gen")
	@SequenceGenerator(name = "companies_gen", sequenceName = "companies_seq", allocationSize = 1)
	private long companyId;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "placeId")
	private Places place;

	public Companies() {
		super();
	}

	public Companies(String name, Places place) {
		super();
		this.name = name;
		this.place = place;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Places getPlace() {
		return place;
	}

	public void setPlace(Places place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyId ^ (companyId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
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
		Companies other = (Companies) obj;
		if (companyId != other.companyId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Companies [companyId=" + companyId + ", name=" + name + ", place=" + place + "]";
	}

}
