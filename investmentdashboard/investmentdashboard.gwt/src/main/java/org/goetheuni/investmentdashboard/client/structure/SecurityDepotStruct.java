package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects of this class represent security depots in the logical structure of
 * the dash board page.
 */
public class SecurityDepotStruct implements EURComputable {

	/**
	 * The data of this security depot
	 */
	protected SecurityDepot data;

	/**
	 * The latest value for the balance.
	 */
	protected BigDecimal cachedBalance;

	/**
	 * The substructures for the investments in this depot.
	 */
	protected List<SecurityInvestmentStruct> investments;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * computeBalanceInEUR(org.goetheuni.investmentdashboard.shared.impl.
	 * SecurityMarketData,
	 * org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData)
	 */
	@Override
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		// validate input
		Objects.requireNonNull(secMarket, "Cannot compute the balance because the given security market data was null");

		// compute the value of all investments
		BigDecimal result = BigDecimal.valueOf(0);

		for (SecurityInvestmentStruct anInvestment : this.investments) {
			// compute the balance for each security investment
			result = result.add(anInvestment.computeBalanceInEUR(secMarket, cryptoMarket));
		}

		// put result into the cache and return it
		this.cachedBalance = result;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * getCachedBalanceInEUR()
	 */
	@Override
	public BigDecimal getCachedBalanceInEUR() {
		return this.cachedBalance;
	}

	/**
	 * Creates a strucutre for the given SecurityDepot. It also generates
	 * substructures for the SecurityInvestments.
	 * 
	 * @param depotData
	 *            The corresponding data object.
	 */
	protected SecurityDepotStruct(SecurityDepot depotData) {
		this.cachedBalance = BigDecimal.ZERO;
		this.data = Objects.requireNonNull(depotData, "The given SecurityDepot data object must not be null.");

		// generate substructures
		List<SecurityInvestmentStruct> investmentStructs = new ArrayList<SecurityInvestmentStruct>();

		for (SecurityInvestment anInvestment : depotData.getPortfolio()) {
			investmentStructs.add(new SecurityInvestmentStruct(anInvestment));
		}
		this.investments = investmentStructs;
	}
}