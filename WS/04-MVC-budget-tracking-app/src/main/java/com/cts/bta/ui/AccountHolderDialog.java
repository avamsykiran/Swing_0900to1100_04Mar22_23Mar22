package com.cts.bta.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cts.bta.controller.AccountHolderDialogController;

public class AccountHolderDialog extends JDialog {

	JTextField txtId;
	JTextField txtName;
	JTextField txtMobile;
	JTextField txtMail;
	JButton btnOk;
	JButton btnCancel;
	
	AccountHolderDialogController ctrl;
	
	public AccountHolderDialog(JFrame parent,AccountHolderDialogController ctrl) {
		super(parent,true);
		setSize(400,300);
		setTitle("AccountHolder");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);
		this.ctrl=ctrl;
	}
	
	public void init() {
		
		
		JPanel pCenter = new JPanel(new GridBagLayout());
		pCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		addLabel(pCenter, "Id", 0, 0);
		addLabel(pCenter, "Mobile Number", 2, 0);
		addLabel(pCenter, "Name", 0, 1);		
		addLabel(pCenter, "Mail Id", 0, 2);
		
		txtId=new JTextField(5);
		txtName=new JTextField(15);
		txtMobile=new JTextField(5);
		txtMail=new JTextField(15);
		
		txtId.setEditable(false);
		
		add(pCenter,txtId,1,0,1,1);
		add(pCenter,txtMobile,3,0,1,1);
		add(pCenter,txtName,1,1,3,1);
		add(pCenter,txtMail,1,2,3,1);
	
		btnOk = new JButton("Save");
		btnCancel = new JButton("Cancel");
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPanel.add(btnOk);
		btnPanel.add(btnCancel);
		
		btnOk.addActionListener(ctrl);
		btnCancel.addActionListener(ctrl);
		
		add(pCenter);
		add(btnPanel,BorderLayout.SOUTH);
	}
	
	public JLabel addLabel(Container ct,String labelText,int x,int y) {
		JLabel label = new JLabel(labelText);
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0;
		gc.gridwidth = 1;
		gc.ipadx = 1;
		gc.anchor = GridBagConstraints.NORTHEAST;
		gc.gridx=x;
		gc.gridy=y;
		ct.add(label,gc);
		return label;
	}
	
	public JComponent add(Container ct,JComponent cmp,int x,int y,int w,int h) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(0, 5, 5, 0);
		gc.gridx=x;
		gc.gridy=y;
		gc.gridwidth=w;
		gc.gridheight=h;
		ct.add(cmp,gc);
		return cmp;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtMobile() {
		return txtMobile;
	}

	public JTextField getTxtMail() {
		return txtMail;
	}
	
	
}
