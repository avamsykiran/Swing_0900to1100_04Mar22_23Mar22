package com.cts.bta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cts.bta.entities.AccountHolder;
import com.cts.bta.service.AccountHolderServiceImpl;
import com.cts.bta.ui.AccountHolderDialog;

public class AccountHolderDialogController implements ActionListener{

	AccountHolder ah;
	AccountHolderDialog ahDailog;
	
	public AccountHolderDialogController(JFrame parent,AccountHolder ah) {
		ahDailog = new AccountHolderDialog(parent,this);
		this.ah=ah;
	}
	
	public AccountHolder getAh() {
		return ah;
	}
	
	public void showAccountHolderDialog() {
		ahDailog.init();
		ahDailog.getTxtId().setText(String.valueOf(ah.getId()));
		ahDailog.getTxtName().setText(ah.getName());
		ahDailog.getTxtMobile().setText(ah.getMobile());
		ahDailog.getTxtMail().setText(ah.getMailId());
		ahDailog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Cancel":
			this.ah=null;
			break;
		case "Save":
			ah.setName(ahDailog.getTxtName().getText());
			ah.setMobile(ahDailog.getTxtMobile().getText());
			ah.setMailId(ahDailog.getTxtMail().getText());
			break;
		}
		ahDailog.dispose();
	}
}