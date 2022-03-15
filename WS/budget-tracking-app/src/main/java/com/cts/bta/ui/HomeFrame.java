package com.cts.bta.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cts.bta.controller.HomeFrameController;
import com.cts.bta.model.AccountHolderTableModel;

public class HomeFrame extends JFrame {

	JTable table;
	HomeFrameController ctrl;
	public HomeFrame(HomeFrameController ctrl) {
		this.ctrl=ctrl;
		setTitle("Budget Tracking Application");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		createMenuBar();
		table = new JTable(new AccountHolderTableModel());
		add(new JScrollPane(table));
	}
	
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu mFile = menubar.add(new JMenu("AccountHolder"));
		mFile.add(new JMenuItem("New")).addActionListener(ctrl);
		mFile.add(new JMenuItem("Refresh")).addActionListener(ctrl);
		mFile.addSeparator();
		mFile.add(new JMenuItem("Exit")).addActionListener(ctrl);
	}

	public void setTableModel(AccountHolderTableModel tableModel) {
		this.table.setModel(tableModel);
	}
	
	public AccountHolderTableModel getTableModel() {
		return (AccountHolderTableModel) this.table.getModel();
	}
}
