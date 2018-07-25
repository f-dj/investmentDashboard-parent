/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 */
public class LeftUIPartBuilder {

	protected static void buildUI(VerticalPanel leftLayoutPanel, RootStructure rootStruct) {

		leftLayoutPanel.add(WidgetCashAccounts.generate(rootStruct.getCashAccounts()));

	}
}