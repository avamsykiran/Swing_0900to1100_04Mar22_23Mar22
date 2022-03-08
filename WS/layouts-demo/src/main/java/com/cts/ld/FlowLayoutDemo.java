package com.cts.ld;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class FlowLayoutDemo extends JDialog {
	
	public FlowLayoutDemo() {
		setTitle("flow layout demo");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		add(new JButton("ONE"));
		add(new JButton("TWO"));
		add(new JButton("THREE"));
		add(new JButton("FOUR"));
		add(new JButton("FIVe"));
		add(new JButton("SIX"));
	}

	public static void main(String[] args) {
		FlowLayoutDemo fd = new FlowLayoutDemo();
		fd.setVisible(true);
	}

}
