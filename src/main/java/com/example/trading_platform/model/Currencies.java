package com.example.trading_platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Currencies {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currencies_gen")
	@SequenceGenerator(name = "currencies_gen", sequenceName = "currencies_seq", allocationSize = 1)
	private long currencyId;

	@Column
	private String symbol;

	@Column
	private String name;

	public Currencies() {
		super();
	}

	public Currencies(String symbol, String name) {
		super();
		this.symbol = symbol;
		this.name = name;
	}

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (currencyId ^ (currencyId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Currencies other = (Currencies) obj;
		if (currencyId != other.currencyId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Currencies [currencyId=" + currencyId + ", symbol=" + symbol + ", name=" + name + "]";
	}

}
