package com.cts.bta.ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.cts.bta.controller.HomeFrameController;
import com.cts.bta.model.AccountHolderTableModel;

public class HomeFrame extends JFrame {

	JTable table;
	HomeFrameController ctrl;
	JMenuItem editMenu;
	JMenuItem deleteMenu;
	
	public HomeFrame(HomeFrameController ctrl) {
		this.ctrl=ctrl;
	}
	
	public void init() {
		setTitle("Budget Tracking Application");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		createMenuBar();
		JPanel tablePanel = new JPanel(new BorderLayout());
		table = new JTable(new AccountHolderTableModel());
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.getSelectionModel().addListSelectionListener(ctrl);
		tablePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		tablePanel.add(new JScrollPane(table));
		add(tablePanel);
	}
	
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu mFile = menubar.add(new JMenu("AccountHolder"));
		mFile.add(new JMenuItem("New")).addActionListener(ctrl);
		editMenu = new JMenuItem("Edit");
		editMenu.setEnabled(false);
		mFile.add(editMenu).addActionListener(ctrl);
		deleteMenu = new JMenuItem("Delete");
		deleteMenu.setEnabled(false);
		mFile.add(deleteMenu).addActionListener(ctrl);
		mFile.addSeparator();
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
	
	public void enableEditAndDelete(boolean enableFlag) {
		editMenu.setEnabled(enableFlag);
		deleteMenu.setEnabled(enableFlag);
	}
}
