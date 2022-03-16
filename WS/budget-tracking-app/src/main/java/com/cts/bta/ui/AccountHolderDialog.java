package com.cts.bta.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountHolderDialog extends JDialog {

	public AccountHolderDialog(JFrame parent) {
		super(parent,true);
		setSize(400,300);
		setTitle("AccountHolder");
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
}
