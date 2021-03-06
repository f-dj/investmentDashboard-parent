package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent information needed for a request at the
 * mid-tier.
 * 
 * JAVADOC DONE
 */
public class RequestInfo {

	/**
	 * The customer's id
	 */
	protected CustomerID customerID;

	/**
	 * The token for authentication
	 */
	protected AuthenticationToken token;

	/**
	 * @return the customerID
	 */
	public CustomerID getCustomerID() {
		return customerID;
	}

	/**
	 * @return the token
	 */
	public AuthenticationToken getToken() {
		return token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		RequestInfo other = (RequestInfo) obj;
		if (customerID == null) {
			if (other.customerID != null) {
				return false;
			}
		} else if (!customerID.equals(other.customerID)) {
			return false;
		}
		if (token == null) {
			if (other.token != null) {
				return false;
			}
		} else if (!token.equals(other.token)) {
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
		return "RequestInfo [customerID=" + customerID + ", token=" + token + "]";
	}

	/**
	 * Creates a container for the customer Id and an authentication token. Can be
	 * used as input for requests at the mid-tier.
	 * 
	 * @param customerID
	 *            The customer's ID
	 * @param token
	 *            An authentication token
	 */
	@JsonCreator
	public RequestInfo(final @JsonProperty("customerID") CustomerID customerID,
			final @JsonProperty("token") AuthenticationToken token) {
		this.customerID = Objects.requireNonNull(customerID, "The given customerID must not be null");
		this.token = Objects.requireNonNull(token, "The given authentication token must not be null");
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected RequestInfo() {
		// required by GWT
	}

}
