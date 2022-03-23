package com.cts.bta.ui;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.cts.bta.controller.HomeFrameController;
import com.cts.bta.entities.AccountHolder;

public class HomeFrame extends JFrame {

	JList<AccountHolder> list;
	HomeFrameController ctrl;
	JMenuItem editMenu;
	JMenuItem deleteMenu;

	public HomeFrame(HomeFrameController ctrl) {
		this.ctrl = ctrl;
	}

	public void init() {
		setTitle("Budget Tracking Application");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createMenuBar();
		JPanel listPanel = new JPanel(new BorderLayout());
		list = new JList<AccountHolder>();
		list.setModel(new DefaultListModel<AccountHolder>());
		list.setCellRenderer(new AccountHolderListCellRenderer());
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.addListSelectionListener(ctrl);

		listPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		listPanel.add(new JScrollPane(list));

		add(listPanel);
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

	public JList<AccountHolder> getList() {
		return list;
	}

	public void enableEditAndDelete(boolean enableFlag) {
		editMenu.setEnabled(enableFlag);
		deleteMenu.setEnabled(enableFlag);
	}
}
