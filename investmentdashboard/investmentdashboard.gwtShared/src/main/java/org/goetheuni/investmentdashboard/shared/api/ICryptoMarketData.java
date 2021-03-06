package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Objects with this interface represent crypto-market data provided by the
 * bank. It also contains reference data for comparison. The concerning point of
 * time must be specified. It may not contain information about all crypto
 * currencies in the market, but only about those, that are relevant for the
 * customer. As GWT is based on source code mapping, these interface can only be
 * used in the server-side code.
 */
public interface ICryptoMarketData {

	/**
	 * @return the exchangeRates
	 */
	public Map<String, BigDecimal> getExchangeRates();

	/**
	 * @return the dateAndTime
	 */
	public Date getDateAndTime();

	/**
	 * Maps an object's values to a number in a deterministic way.
	 * 
	 * @return the number
	 */
	public int hashCode();

	/**
	 * @return the reference values for the contained crypto assets.
	 */
	public Map<String, BigDecimal> getReferenceValues();

	/**
	 * Returns true if the objects values are equal to the given object. Otherwise
	 * false.
	 * 
	 * @param obj
	 *            The object for comparison.
	 * @return True if the object's values are equal otherwise false.
	 */
	public boolean equals(Object obj);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
