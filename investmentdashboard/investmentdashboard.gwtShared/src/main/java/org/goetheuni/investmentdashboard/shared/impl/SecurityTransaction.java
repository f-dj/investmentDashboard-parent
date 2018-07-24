package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ISecurityTransaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents an executed transaction of securities.
 */
public class SecurityTransaction implements ISecurityTransaction {

	/**
	 * The quantity that has been traded. Positive for a buy transaction and
	 * negative for a sell transaction.
	 */
	protected long quantity;

	/**
	 * The total prize of the securities. It is assumed to be non-negative.
	 */
	protected BigDecimal totalPrize;

	/**
	 * The security that has been traded.
	 */
	protected Security security;

	/**
	 * The date and time of the execution.
	 */
	protected Date dateOfExecution;

	/**
	 * @return the quantity
	 */
	@Override
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @return the totalPrize
	 */
	@Override
	public BigDecimal getTotalPrize() {
		return totalPrize;
	}

	/**
	 * @return the security
	 */
	@Override
	public Security getSecurity() {
		return security;
	}

	/**
	 * @return the dateOfExecution
	 */
	@Override
	public Date getDateOfExecution() {
		return dateOfExecution;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfExecution == null) ? 0 : dateOfExecution.hashCode());
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + ((totalPrize == null) ? 0 : totalPrize.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SecurityTransaction other = (SecurityTransaction) obj;
		if (dateOfExecution == null) {
			if (other.dateOfExecution != null) {
				return false;
			}
		} else if (!dateOfExecution.equals(other.dateOfExecution)) {
			return false;
		}
		if (quantity != other.quantity) {
			return false;
		}
		if (security == null) {
			if (other.security != null) {
				return false;
			}
		} else if (!security.equals(other.security)) {
			return false;
		}
		if (totalPrize == null) {
			if (other.totalPrize != null) {
				return false;
			}
		} else if (!totalPrize.equals(other.totalPrize)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityTransaction [quantity=" + quantity + ", totalPrize=" + totalPrize + ", security=" + security
				+ ", dateOfExecution=" + dateOfExecution + "]";
	}

	/**
	 * Creates a transaction of securities. All parameters must not be null.
	 * 
	 * @param quantity
	 * @param totalPrize
	 * @param security
	 * @param dateOfExecution
	 */
	@JsonCreator
	public SecurityTransaction(final @JsonProperty("quantity") long quantity,
			final @JsonProperty("totalPrize") BigDecimal totalPrize, final @JsonProperty("security") Security security,
			final @JsonProperty("dateOfExecution") Date dateOfExecution) {
		this.quantity = quantity;
		this.totalPrize = Objects.requireNonNull(totalPrize, "The object for the total prize must not be null");

		// the price is assumed to be non negative
		if (totalPrize.signum() < 0) {
			throw new IllegalArgumentException("The total prize of a security transaction must not be negative. It is: "
					+ totalPrize.doubleValue());
		}

		this.security = Objects.requireNonNull(security, "The given security must not be null");
		this.dateOfExecution = Objects.requireNonNull(dateOfExecution, "The date must not be null");
	}

	protected SecurityTransaction() {
		// required by GWT
	}
}