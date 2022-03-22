package com.cts.bta.model;

import javax.swing.table.DefaultTableModel;

public class AccountHolderTableModel extends DefaultTableModel{

	public AccountHolderTableModel() {
		/*this.addColumn("Id");
		this.addColumn("Name");
		this.addColumn("Mobile Number");
		this.addColumn("Email Id");
		this.addColumn("Balance");*/
		this.setColumnIdentifiers(new String[] {"Id","Name","Mobile Number","Email Id","Balance"});
	}
}
