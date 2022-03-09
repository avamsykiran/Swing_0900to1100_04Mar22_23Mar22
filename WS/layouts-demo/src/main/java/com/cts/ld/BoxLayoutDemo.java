package com.cts.ld;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class BoxLayoutDemo extends JDialog {

	public BoxLayoutDemo() {
		setTitle("Box layout demo");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		JPanel rows[] = new JPanel[4];

		add(Box.createVerticalGlue());
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new JPanel();
			rows[i].setLayout(new BoxLayout(rows[i], BoxLayout.LINE_AXIS));

			for (int j = 1; j <= 5; j++) {
				rows[i].add(Box.createRigidArea(new Dimension(5, 0)));
				rows[i].add(new JButton(String.format("Button[%d,%d]", i,j)));
			}

			add(Box.createRigidArea(new Dimension(0, 5)));
			add(rows[i]);
		}
		
		add(Box.createVerticalGlue());
	}

	public static void main(String[] args) {
		BoxLayoutDemo window = new BoxLayoutDemo();
		window.setVisible(true);
	}

}
