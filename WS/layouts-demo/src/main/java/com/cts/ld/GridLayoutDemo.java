package com.cts.ld;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class GridLayoutDemo extends JDialog {
	
	public GridLayoutDemo() {
		setTitle("Grid layout demo");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new GridLayout(4,3));
		
		for(int i=1;i<=12;i++)
			add(new JButton("Button#"+i));
		
	}

	public static void main(String[] args) {
		GridLayoutDemo fd = new GridLayoutDemo();
		fd.setVisible(true);
	}

}
