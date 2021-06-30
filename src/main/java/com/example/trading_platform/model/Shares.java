package com.example.trading_platform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Shares {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shares_gen")
	@SequenceGenerator(name = "shares_gen", sequenceName = "shares_seq", allocationSize = 1)
	private long shareId;

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Companies company;

	@ManyToOne
	@JoinColumn(name = "currencyId")
	private Currencies currency;

	public Shares() {
		super();
	}

	public Shares(Companies company, Currencies currency) {
		super();
		this.company = company;
		this.currency = currency;
	}

	public long getShareId() {
		return shareId;
	}

	public void setShareId(long shareId) {
		this.shareId = shareId;
	}

	public Companies getCompany() {
		return company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency(Currencies currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + (int) (shareId ^ (shareId >>> 32));
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
		Shares other = (Shares) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (shareId != other.shareId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shares [shareId=" + shareId + ", company=" + company + ", currency=" + currency + "]";
	}

}
