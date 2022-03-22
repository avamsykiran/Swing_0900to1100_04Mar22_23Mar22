package com.cts.ld;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridBagLayoutDemo extends JDialog {
	
	public GridBagLayoutDemo() {
		setTitle("Grid Bag layout demo");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new GridBagLayout());
		
		add(new JLabel("Frist Name"),0,0,1,1);
		add(new JTextField(),1,0,1,1);
		add(new JLabel("Middle Name"),2,0,1,1);
		add(new JTextField(),3,0,1,1);
		add(new JLabel("Last Name"),4,0,1,1);
		add(new JTextField(),5,0,1,1);
		add(new JLabel("Identifiction Mark 1"),0,1,1,1);
		add(new JTextArea(),1,1,5,2);
		add(new JLabel("Identifiction Mark 1"),0,3,1,1);
		add(new JTextArea(),1,1,5,2);
	}

	void add(JComponent c,int x,int y,int w,int h) {
		GridBagConstraints con = new GridBagConstraints();
		con.gridx=x;
		con.gridy=y;
		con.gridwidth=w;
		con.gridheight=h;
		con.fill=GridBagConstraints.BOTH;
		con.weightx=0.5;
		add(c,con);
	}
	
	public static void main(String[] args) {
		GridBagLayoutDemo fd = new GridBagLayoutDemo();
		fd.setVisible(true);
	}

}
