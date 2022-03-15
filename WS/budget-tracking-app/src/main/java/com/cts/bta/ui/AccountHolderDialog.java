package com.cts.bta.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class AccountHolderDialog extends JDialog {

	public AccountHolderDialog(JFrame parent) {
		super(parent,true);
		setSize(400,300);
		setTitle("AccountHolder");
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
