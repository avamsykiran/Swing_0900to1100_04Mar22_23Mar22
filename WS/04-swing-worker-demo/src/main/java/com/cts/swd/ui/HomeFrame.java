package com.cts.swd.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.cts.swd.controller.HomeFrameController;

public class HomeFrame extends JFrame {

	JSpinner spOperand1;
	JSpinner spOperand2;
	JList<Integer> listResults;
	JProgressBar progressBar;
	JButton btnStart;
	HomeFrameController ctrl;

	public HomeFrame(HomeFrameController ctrl) {
		this.ctrl = ctrl;
		setTitle("Swing Worker Demo");
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void init() {

		JPanel panelTop = new JPanel(new GridLayout(1,5));
		JPanel panelCenter = new JPanel(new BorderLayout());
		JPanel panelBottom = new JPanel(new BorderLayout());
		
		panelTop.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelBottom.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		add(panelTop,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
		add(panelBottom,BorderLayout.SOUTH);
		
		spOperand1 = new JSpinner(new SpinnerNumberModel(10, 1, 5000, 5));
		spOperand2 = new JSpinner(new SpinnerNumberModel(10, 1, 5000, 5));
		
		btnStart = new JButton("start");
		
		spOperand1.addChangeListener(ctrl);
		spOperand2.addChangeListener(ctrl);
		btnStart.addActionListener(ctrl);
		
		panelTop.add(new JLabel("Lower Limit: ", JLabel.RIGHT));
		panelTop.add(spOperand1);
		panelTop.add(new JLabel("Upper Limit: ", JLabel.RIGHT));
		panelTop.add(spOperand2);
		panelTop.add(btnStart);
		
		listResults = new JList<Integer>(new DefaultListModel<Integer>());
		listResults.setLayoutOrientation(JList.VERTICAL_WRAP);
		panelCenter.add(new JScrollPane(listResults));
		
		progressBar = new JProgressBar();
		panelBottom.add(progressBar);
	}

	public JSpinner getSpOperand1() {
		return spOperand1;
	}

	public JSpinner getSpOperand2() {
		return spOperand2;
	}

	public JList<Integer> getListResults() {
		return listResults;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JButton getBtnStart() {
		return btnStart;
	}
	
	
}
