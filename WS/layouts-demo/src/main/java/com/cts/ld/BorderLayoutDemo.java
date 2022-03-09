package com.cts.ld;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class BorderLayoutDemo extends JDialog {
	
	public BorderLayoutDemo() {
		setTitle("Border layout demo");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//setLayout(new BorderLayout()); as the default is border layout
		
		add(new JButton("CENTER BTN"));
		add(new JButton("NORTH BTN"),BorderLayout.NORTH);
		add(new JButton("SOUTH BTN"),BorderLayout.SOUTH);
		add(new JButton("EAST BTN"),BorderLayout.EAST);
		add(new JButton("WEST BTN"),BorderLayout.WEST);
		
	}

	public static void main(String[] args) {
		BorderLayoutDemo fd = new BorderLayoutDemo();
		fd.setVisible(true);
	}

}
