package com.cts.bta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cts.bta.entities.AccountHolder;
import com.cts.bta.exceptions.BTAException;
import com.cts.bta.model.AccountHolderTableModel;
import com.cts.bta.service.AccountHolderService;
import com.cts.bta.service.AccountHolderServiceImpl;
import com.cts.bta.ui.AccountHolderDialog;
import com.cts.bta.ui.HomeFrame;

public class HomeFrameController implements ActionListener, ListSelectionListener {

	private HomeFrame homeFrame;
	private AccountHolderService ahService;
	private int selectedRowIndex;

	public HomeFrameController() {
		homeFrame = new HomeFrame(this);
		ahService = new AccountHolderServiceImpl();
		selectedRowIndex = -1;
	}

	public void loadData() {
		AccountHolderTableModel model = homeFrame.getTableModel();
		model.setRowCount(0);
		try {
			List<AccountHolder> ahs = ahService.getAll();
			for (AccountHolder ah : ahs) {
				model.addRow(
						new Object[] { ah.getId(), ah.getName(), ah.getMobile(), ah.getMailId(), ah.getBalance() });
			}
			homeFrame.enableEditAndDelete(false);
		} catch (BTAException e) {
			JOptionPane.showMessageDialog(homeFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void showHomeFrame() {
		homeFrame.init();
		homeFrame.setVisible(true);
	}

	public void addAccountHolder() {
		try {
			AccountHolderDialogController ahc = new AccountHolderDialogController(homeFrame,
					new AccountHolder(ahService.nextAccountHolderId(), "", "", "", 0.0));
			ahc.showAccountHolderDialog();

			if (ahc.getAh() != null) {
				ahService.add(ahc.getAh());
				loadData();
			}
		} catch (BTAException e) {
			JOptionPane.showMessageDialog(homeFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void editAccountHolder() {
		try {

			Long ahId = (Long) homeFrame.getTableModel().getValueAt(selectedRowIndex, 0);

			AccountHolderDialogController ahc = new AccountHolderDialogController(homeFrame, ahService.getById(ahId));
			ahc.showAccountHolderDialog();

			if (ahc.getAh() != null) {
				ahService.modify(ahc.getAh());
				loadData();
			}
		} catch (BTAException e) {
			JOptionPane.showMessageDialog(homeFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
	
	public void delAccountHolder() {
		try {

			Long ahId = (Long) homeFrame.getTableModel().getValueAt(selectedRowIndex, 0);
			
			int dailogResult = JOptionPane.showConfirmDialog(homeFrame, "Are you of deleting AccountHolder#"+ahId+"?",
					"Confirm Deletion",JOptionPane.YES_NO_OPTION);
			
			if(dailogResult==JOptionPane.YES_OPTION) {
				ahService.deleteById(ahId);
				loadData();
			}		
			
		} catch (BTAException e) {
			JOptionPane.showMessageDialog(homeFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "New":
			addAccountHolder();
			break;
		case "Edit":
			editAccountHolder();
			break;
		case "Delete":
			delAccountHolder();
			break;
		case "Refresh":
			loadData();
			break;
		case "Exit":
			homeFrame.dispose();
			break;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		selectedRowIndex = e.getFirstIndex();
		homeFrame.enableEditAndDelete(selectedRowIndex > -1);
	}
}
